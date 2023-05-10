//
//  boj_16234.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/05.
//
//  인구 이동
//  https://www.acmicpc.net/problem/16234

var input = readLine()!.split(separator: " ").map{Int(String($0))!}
let number = input[0]
let L = input[1]
let R = input[2]
var graph = [[Int]]()
var visited = Array(repeating: Array(repeating: false, count: number), count: number)

for _ in 0..<number {
    graph.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}

let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]

func bfs(_ y: Int, _ x: Int) -> Int {
    visited[y][x] = true
    var queue = [(Int, Int)]()
    var index = 0
    queue.append((y, x))
    var totalPeople = 0
    totalPeople += graph[y][x]
    
    while queue.count > index {
        let (nowY, nowX) = queue[index]
        index += 1
        
        for i in 0..<4 {
            let nx = dx[i] + nowX
            let ny = dy[i] + nowY
            
            if 0..<number ~= nx && 0..<number ~= ny && !visited[ny][nx] {
                if L <= abs(graph[ny][nx]-graph[nowY][nowX]), abs(graph[ny][nx]-graph[nowY][nowX]) <= R {
                    visited[ny][nx] = true
                    queue.append((ny, nx))
                    totalPeople += graph[ny][nx]
                }
            }
        }
    }
    
    let totalCount = queue.count
    let movePeople = totalPeople/totalCount
    
    for (y, x) in queue {
        graph[y][x] = movePeople
    }
    
    return totalCount
}

var count = 0

while true {
    var flag = true
    visited = Array(repeating: Array(repeating: false, count: number), count: number)
    
    for i in 0..<number {
        for j in 0..<number {
            if !visited[j][i] {
                if bfs(j, i) >= 2 {
                    flag = false
                }
            }
        }
    }
    
    if flag {
        break
    }
    
    count += 1
}

print(count)

// 메모리 : 69268 KB, 시간 : 612 ms
