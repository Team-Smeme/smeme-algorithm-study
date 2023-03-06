//
//  boj_16236.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/06.
//
//  아기 상어
//  https://www.acmicpc.net/problem/16236

/*
 1. 처음 아기 상어의 크기는 2, 상하좌우로 인접한 한칸씩 이동
 2. 아기 상어의 크기보다 큰 물고기는 지나갈 수 없고, 크기가 작은 물고기는 먹을 수 있고, 크기가 같은 물고기는 지나갈 수 있다.
 3. 먹을 수 있는 물고기가 한마리라면, 그 물고기를 먹는다.
 4. 먹을 수 있는 물고기가 한마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
 5. 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러 마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
 6. 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1 증가한다. 예를 들어 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
 */

let N = Int(readLine()!)!
var graph = [[Int]]()
var shark = (0, 0, 0)
var eatCount = 0
var time = 0

for i in 0..<N {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    graph.append(input)
    
    if let j = input.firstIndex(of: 9) {
        shark = (i, j, 2)
        graph[i][j] = 0
    }
}

func bfs() -> Bool {
    var queue = [(shark.0, shark.1, 0)]
    var index = 0
    
    var visited = Array(repeating: Array(repeating: false, count: N), count: N)
    visited[shark.0][shark.1] = true
    
    let dx = [-1, 1, 0, 0]
    let dy = [0, 0, -1, 1]
    
    var distance = Int.max
    var fishArray = [(Int, Int)]()
    
    while queue.count > index {
        let (x, y, count) = queue[index]
        index += 1
        
        if count > distance { continue }
        
        if (1..<shark.2).contains(graph[x][y]) {
            distance = count
            fishArray.append((x, y))
        }
        
        for i in 0..<4 {
            let nx = dx[i] + x
            let ny = dy[i] + y
            
            if 0..<N ~= nx && 0..<N ~= ny && !visited[nx][ny] && graph[nx][ny] <= shark.2 {
                visited[nx][ny] = true
                queue.append((nx, ny, count+1))
            }
        }
    }
    
    if fishArray.isEmpty {
        return false
    }
    
    fishArray.sort {
        if $0.0 == $1.0 {
            return $0.1 < $1.1
        }
        return $0.0 < $1.0
    }
    
    let target = fishArray.first!
    eatCount += 1
    
    if eatCount == shark.2 {
        shark.2 += 1
        eatCount = 0
    }
    
    graph[target.0][target.1] = 0
    shark = (target.0, target.1, shark.2)
    
    time += distance
    return true
}

while true {
    if !bfs() {
        print(time)
        break
    }
}

// 메모리 : 69112 KB, 시간 : 8 ms

