//
//  boj_7569.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/01.
//
//  토마토 (3차원)
//  https://www.acmicpc.net/problem/7569

let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let (x, y, z) = (input[0], input[1], input[2])
var graph = Array(repeating: Array(repeating: Array(repeating: 0, count: 0), count: 0), count: z)
var queue = [(Int, Int, Int, Int)]()

for z in 0..<z {
    for _ in 0..<y {
        graph[z].append(readLine()!.split(separator: " ").map{Int(String($0))!})
    }
}

// 토마토 개수만큼 queue에 추가
for z in 0..<z {
    for y in 0..<y {
        for x in 0..<x {
            if graph[z][y][x] == 1 {
                queue.append((z, y, x, 0))
            }
        }
    }
}

var index = 0
var result = 0

func bfs() {
    while queue.count > index {
        let (tomatoZ, tomatoY, tomatoX, day) = queue[index]
        index += 1
        
        let dz = [1, -1, 0, 0, 0, 0]
        let dy = [0, 0, 1, -1, 0, 0]
        let dx = [0, 0, 0, 0, 1, -1]
        
        for i in 0..<6 {
            let nz = tomatoZ + dz[i]
            let ny = tomatoY + dy[i]
            let nx = tomatoX + dx[i]
            let nextDay = day+1
            
            if 0..<z ~= nz && 0..<y ~= ny && 0..<x ~= nx && graph[nz][ny][nx] == 0 {
                graph[nz][ny][nx] = 1
                queue.append((nz, ny, nx, nextDay))
                result = nextDay
            }
        }
    }
}

bfs()

// 익지 않은 토마토가 존재할 때
for z in 0..<z {
    for y in 0..<y {
        for x in 0..<x {
            if graph[z][y][x] == 0 {
                result = -1
            }
        }
    }
}

print(result)

// 메모리 : 128188 KB, 시간 : 392 ms

