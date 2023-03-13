//
//  boj_1600.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/06.
//
//  말이 되고픈 원숭이
//  https://www.acmicpc.net/problem/1600

let jumpCount = Int(readLine()!)!
let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let w = input[0]
let h = input[1]
var graph = [[Int]]()
var result = -1

let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]
let horseDx = [-2, -1, -2, -1, 1, 2, 1,  2]
let horseDy = [1, 2, -1, -2, -2, -1, 2, 1]

for _ in 0..<h {
    graph.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}

func bfs() {
    // x, y, count, jumoCount
    var queue = [(0, 0, 0, jumpCount)]
    var index = 0
    // 1번의 점프가 가능하다고 했을 때, 점프를 안 하는 경우도 생각해야 하기 때문에 +1
    var visited = Array(repeating: Array(repeating: Array(repeating: false, count: jumpCount+1), count: w), count: h)
    visited[0][0][jumpCount] = true
    
    while queue.count > index {
        let (y, x, count, jumpCount) = queue[index]
        index += 1
        
        // 바로 도착했을 경우 최단거리이기 때문에 break
        if x == w-1 && y == h-1 {
            result = count
            break
        }
        
        if jumpCount > 0 {
            for i in 0..<8 {
                let horseNx = horseDx[i] + x
                let horseNy = horseDy[i] + y
                
                // 점프 횟수 감소
                if 0..<w ~= horseNx && 0..<h ~= horseNy && !visited[horseNy][horseNx][jumpCount-1] && graph[horseNy][horseNx] == 0 {
                    visited[horseNy][horseNx][jumpCount-1] = true
                    queue.append((horseNy, horseNx, count+1, jumpCount-1))
                }
            }
        }
        
        for i in 0..<4 {
            let nx = dx[i] + x
            let ny = dy[i] + y
            
            if 0..<w ~= nx && 0..<h ~= ny && !visited[ny][nx][jumpCount] && graph[ny][nx] == 0 {
                visited[ny][nx][jumpCount] = true
                queue.append((ny, nx, count+1, jumpCount))
            }
        }
        
        result = min(count, result)
    }
}

bfs()
print(result)

// 메모리 : 174016 KB, 시간 : 176 ms
