//
//  boj_2636.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/14.
//
//  치즈
//  https://www.acmicpc.net/problem/2636

let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let height = input[0]
let width = input[1]
var cheezeGraph = [[Int]]()
var visited = Array(repeating: Array(repeating: false, count: width), count: height)
var cheeseCount = [Int]()
var queue = [(Int, Int)]()
var count = 0

for _ in 0..<height {
    cheezeGraph.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}

let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]

var index = 0

func bfs() -> Int {
    visited = Array(repeating: Array(repeating: false, count: width), count: height)
    queue.append((0, 0))
    visited[0][0] = true
    count = 0
    
    while queue.count > index {
        let (y, x) = queue[index]
        index += 1
        
        for i in 0..<4 {
            let nx = dx[i] + x
            let ny = dy[i] + y
            
            if 0..<width ~= nx && 0..<height ~= ny && !visited[ny][nx] {
                // 공기일 때
                if cheezeGraph[ny][nx] == 0 {
                    queue.append((ny, nx))
                    visited[ny][nx] = true
                } else if cheezeGraph[ny][nx] == 1 {
                    visited[ny][nx] = true
                    cheezeGraph[ny][nx] = 0
                    count += 1
                }
            }
        }
    }
    cheeseCount.append(count)
    return count
}


var time = -1

while true {
    time += 1
    count = bfs()
    // 더이상 치즈가 없을 때
    if count == 0 {
        break
    }
}

print(time)
print(cheeseCount[cheeseCount.count-2])

// 메모리 : 70716 KB, 시간 : 12 ms
