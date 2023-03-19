//
//  boj_11559.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/16.
//
//  Puyo Puyo
//  https://www.acmicpc.net/problem/11559

/*
 1. 4개 이상일 때 뿌요가 터짐
 2. 뿌요가 터지면 그래프 내려줌
 3. 뿌요가 남아 있는지 확인해 주어야 함
 4. 하나도 안 터졌을 때는 0 출력
 5. 터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 함
 */

var graph = [[String]]()
var queue = [(Int, Int)]()
var visited = Array(repeating: Array(repeating: false, count: 6), count: 12)

for _ in 0..<12 {
    graph.append(readLine()!.map{String($0)})
}

var index = 0

let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]

func bfs(_ y: Int, _ x: Int) -> Int {
    queue.append((y, x))
    
    // 터질 뿌요들의 위치와 개수를 같이 담아 주는 배열
    var puyoArray = [(Int, Int)]()
    // bfs 들어온 순간 이미 뿌요 개수 1임
    var puyoCount = 1
    var returnPuyo = 0
    puyoArray.append((y, x))
    
    while queue.count > index {
        let (nowY, nowX) = queue[index]
        index += 1
        
        for i in 0..<4 {
            let nx = dx[i] + nowX
            let ny = dy[i] + nowY
            
            if 0..<6 ~= nx && 0..<12 ~= ny && !visited[ny][nx] && graph[ny][nx] == graph[y][x] {
                visited[ny][nx] = true
                queue.append((ny, nx))
                puyoArray.append((ny, nx))
                puyoCount += 1
            }
        }
    }
    
    // 터지는 뿌요
    if puyoCount >= 4 {
        returnPuyo = 1
        
        // 뿌요 터트리기
        deletePoyu(puyoArray)
    }
    
    return returnPuyo
}

func deletePoyu(_ array: [(Int, Int)]) {
    for (y, x) in array {
        graph[y][x] = "."
    }
}

func movePoyu() {
    for i in 0..<6 {
        var queue = [String]()
        for j in stride(from: 11, through: 0, by: -1) {
            // 이동해야 할 뿌요들은 큐에 담아줌
            if graph[j][i] != "." {
                queue.append(graph[j][i])
                // 큐에 담은 뿌요는 지워 준다
                graph[j][i] = "."
            }
        }
    
        for j in stride(from: 11, through: 0, by: -1) {
            // 이동 시켜줄 뿌요들이 있다면
            if !queue.isEmpty {
                let poyu = queue.removeFirst()
                // 뿌요 이동 시키고
                graph[j][i] = poyu
            } else {
                break
            }
        }
    }
}

var result = 0

while true {
    var count = 0
    for i in 0..<12 {
        for j in 0..<6 {
            if graph[i][j] != "." && !visited[i][j] {
                visited[i][j] = true
                count += bfs(i, j)
            }
        }
    }
    // 더이상 터질 뿌요가 없다면
    if count == 0 {
        print(result)
        break
    } else {
        result += 1
    }
    // 뿌요 이동시켜주기
    movePoyu()
    
    // 뿌요 방문 초기화
    visited = Array(repeating: Array(repeating: false, count: 6), count: 12)
}

// 메모리 : 69104 KB, 시간 : 8 ms
