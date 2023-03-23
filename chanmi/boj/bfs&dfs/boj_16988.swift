//
//  boj_16988.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/23.
//
//  Baaaaaaaaaduk2 (Easy)
//  https://www.acmicpc.net/problem/16988

/*
 어려웠던 부분
 
 1. 내 바둑돌을 둘 위치를 전부 다 돌아야 하는데, 그 부분에서 좀 헤맸음. 무작정 bfs 함수를 실행시키는 것이 아니라, 그래프를 차례대로 전부 돌아보면서 내 바둑돌이 2개일 때의 조건에서 bfs 함수를 실행시켰음.
 2. 그러고 무작정 bfs 함수를 그래프 전부 돌게 했더니 무지막지하게 큰 수가 나와 버렸음. bfs 함수는 상대 바둑돌(2)의 개수만큼만 돌게 해 줬고, bfs 함수 안에서 현재 위치에서 인접한 위치에 (상대 바둑돌(2) and 방문하지 않은 상대 바둑돌(2))가 있을 경우 해당 다음 좌표를 queue에 넣어 주면서 계속 탐색하게 해 주면서 count 해 주었다.
 3. bfs 함수에서 0을 만났을 경우 bool 타입의 flag를 false로 바꿔 주는 과정. 처음에는 0을 만났을 때 그냥 0을 출력하고, 기본 return을 count로 해 주었는데, 그렇게 되면 2가 뭉쳐 있지만, 에어싸워져 있지 않은 바둑돌일 경우, 뭉쳐 있는 바둑돌만큼의 count 값이 일단 출력되므로, bool 타입의 flag로 제한을 두었다.
 4. bfs에 들어온 순간부터 상대 바둑돌(2)가 하나 있는 것이므로 count = 1로 선언해 주었다.
 5. 내 바둑돌을 2개 두고, bfs를 돌기 전에 상대 바둑돌(2) 위치를 초기화하는 작업이 필요함. 브루트포스로 모든 상황을 다 돌아봐야 하기 때문에, 초기화해 주지 않으면 한번의 경우를 돌고, 더이상 bfs를 돌지 않게 됨.
 6. 바둑돌이 모여 있지 않고, 떨어져 있는 경우들도 있기 때문에, bfs를 돌고 나온 값들을 모두 더해 주는 과정이 있어야 한다. bfs를 돌려서 나온 값들을 더하지 않고, 그냥 countSum 변수에 선언해 버려서 총합의 결과가 나오지 않았다.
 */

let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let col = input[0]
let row = input[1]
var graph = [[Int]]()
var queue = [(Int, Int)]()
var rivalBadukQueue = [(Int, Int)]()
var visited = Array(repeating: Array(repeating: false, count: row), count: col)
var rivalBadukVisited = Array(repeating: Array(repeating: false, count: row), count: col)

for i in 0..<col {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    graph.append(input)
    
    for j in 0..<row {
        if graph[i][j] == 2 {
            rivalBadukQueue.append((i, j))
        }
    }
}

let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]

var result = 0

func makeBaduk(_ count: Int) {
    if count == 2 {
        var countSum = 0
        // 바둑돌 방문 초기화 작업
        rivalBadukVisited = Array(repeating: Array(repeating: false, count: row), count: col)
        for (y, x) in rivalBadukQueue {
            if !rivalBadukVisited[y][x] {
                countSum += bfs(y, x)
            }
        }
        result = max(result, countSum)
    } else {
        for i in 0..<col {
            for j in 0..<row {
                if graph[i][j] == 0 && !visited[i][j] {
                    visited[i][j] = true
                    graph[i][j] = 1
                    makeBaduk(count+1)
                    visited[i][j] = false
                    graph[i][j] = 0
                }
            }
        }
    }
}

var index = 0

func bfs(_ y: Int, _ x: Int) -> Int {
    rivalBadukVisited[y][x] = true
    queue.append((y, x))
    var count = 1
    var flag = true
    
    while queue.count > index {
        let (nowY, nowX) = queue[index]
        index += 1
        
        for i in 0..<4 {
            let nx = dx[i] + nowX
            let ny = dy[i] + nowY
            
            if 0..<row ~= nx && 0..<col ~= ny {
                // 방문하지 않았고, 2 바둑돌이라면 count += 1
                if graph[ny][nx] == 2 && !rivalBadukVisited[ny][nx] {
                    rivalBadukVisited[ny][nx] = true
                    count += 1
                    queue.append((ny, nx))
                } else if graph[ny][nx] == 0 {
                    flag = false
                }
            }
        }
    }
    // 바둑돌 bfs를 모두 돌았을 때, flag가 true이면 return count
    if flag {
        return count
    }
    
    // 빈공간이 있었다면 0
    return 0
}

makeBaduk(0)

print(result)


// 메모리 : 321028 KB, 시간 : 832 ms
