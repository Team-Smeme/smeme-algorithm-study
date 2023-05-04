//
//  boj_2589.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/04.
//
//  보물섬
//  https://www.acmicpc.net/problem/2589

let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let L = input[0]
let W = input[1]
var graph = [[String]]()
var visited = Array(repeating: Array(repeating: false, count: W), count: L)

for _ in 0..<L {
    graph.append(readLine()!.map{String($0)})
}

var queue = [(Int, Int, Int)]()
var index = 0

let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]

func bfs(_ y: Int, _ x: Int) -> Int {
    var result = 0
    var visited = Array(repeating: Array(repeating: false, count: W), count: L)
    visited[y][x] = true
    queue.append((y, x, 0))
    
    while queue.count > index {
        let (nowY, nowX, nowCount) = queue[index]
        index += 1
        
        for i in 0..<4 {
            let ny = dy[i]+nowY
            let nx = dx[i]+nowX
            
            if 0..<L ~= ny && 0..<W ~= nx && graph[ny][nx] == "L" && !visited[ny][nx] {
                queue.append((ny, nx, nowCount+1))
                visited[ny][nx] = true
                result = max(nowCount+1, result)
            }
        }
    }
    return result
}

var result = 0

for i in 0..<L {
    for j in 0..<W {
        if graph[i][j] == "L" {
            let distance = bfs(i, j)
            result = max(distance, result)
        }
    }
}

print(result)
