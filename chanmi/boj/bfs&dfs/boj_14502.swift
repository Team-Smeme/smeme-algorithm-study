//
//  boj_14502.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/07.
//
//  연구소
//  https://www.acmicpc.net/problem/14502

let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let N = input[0]
let M = input[1]
var graph = [[Int]]()
var queue = [(Int, Int)]()
var result = 0

for _ in 0..<N {
    graph.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}

func makeWall(_ count: Int) {
    if count == 3 {
        bfs()
        return
    } else {
        for i in 0..<N {
            for j in 0..<M {
                if graph[i][j] == 0 {
                    graph[i][j] = 1
                    makeWall(count+1)
                    graph[i][j] = 0
                }
            }
        }
    }
}

var index = 0

func bfs() {
    for i in 0..<N {
        for j in 0..<M {
            if graph[i][j] == 2 {
                queue.append((i, j))
            }
        }
    }
    
    var virusGraph = graph

    while queue.count > index {
        let (y, x) = queue[index]
        index += 1
        
        let dx = [-1, 1, 0, 0]
        let dy = [0, 0, -1, 1]

        for i in 0..<4 {
            let nx = dx[i] + x
            let ny = dy[i] + y

            if 0..<N ~= ny && 0..<M ~= nx && virusGraph[ny][nx] == 0 {
                virusGraph[ny][nx] = 2
                queue.append((ny, nx))
            }
        }
    }
    
    var count = 0
    for i in 0..<N {
        for j in 0..<M {
            if virusGraph[i][j] == 0 {
                count += 1
            }
        }
    }
    result = max(result, count)
}

makeWall(0)
print(result)

// 메모리 : 메모리 : 468476 KB, 시간 : 960 ms
