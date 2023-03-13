//
//  boj_6118.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/13.
//
//  숨바꼭질
//  https://www.acmicpc.net/problem/6118

let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let N = input[0]
let M = input[1]
var visited = Array(repeating: false, count: N+1)
var graph = Array(repeating: Array(repeating: 0, count: 0), count: N+1)
var resultQueue = [Int:Int]()

for _ in 0..<M {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    let a = input[0]
    let b = input[1]
    
    graph[a].append(b)
    graph[b].append(a)
    
    // 시간 초과 안 걸리나...
    graph[a].sort()
    graph[b].sort()
}

// 큐에 담길 값은 현재 위치랑 depth
var queue = [(1, 0)]
visited[1] = true
var index = 0

bfs()

func bfs() {
    while queue.count > index {
        let (now, distance) = queue[index]
        index += 1
        
        for i in graph[now] {
            if !visited[i] {
                visited[i] = true
                queue.append((i, distance+1))
                resultQueue[i, default: 0] = distance+1
            }
        }
    }
}

let maxDistance = resultQueue.values.max()!
var result = 0
var minNumber = Int.max

for (key, value) in resultQueue {
    if value == maxDistance {
        result += 1
        if key < minNumber {
            minNumber = key
        }
    }
}

let resultArray = [minNumber, maxDistance, result]

print(resultArray.map{String($0)}.joined(separator: " "))

// 메모리 : 72708 KB, 시간 : 152 ms
