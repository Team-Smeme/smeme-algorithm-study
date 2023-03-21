//
//  boj_9205.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/21.
//
//  맥주 마시면서 걸어가기
//  https://www.acmicpc.net/problem/9205

let testCase = Int(readLine()!)!

for _ in 0..<testCase {
    var graph = [(Int, Int)]()
    
    let n = Int(readLine()!)!
    let home = readLine()!.split(separator: " ").map{Int(String($0))!}
    graph.append((home[0], home[1]))
    
    for _ in 0..<n {
        let store = readLine()!.split(separator: " ").map{Int(String($0))!}
        graph.append((store[0], store[1]))
    }
    
    let end = readLine()!.split(separator: " ").map{Int(String($0))!}
    graph.append((end[0], end[1]))
    
    var bfsGraph = Array(repeating: Array(repeating: 0, count: 0), count: n+2)
    
    for i in 0..<graph.count-1 {
        for j in i+1..<graph.count {
            // 거리가 1000 이하일 경우만 이동할 수 있으므로
            if abs(graph[i].0 - graph[j].0) + abs(graph[i].1 - graph[j].1) <= 1000 {
                bfsGraph[i].append(j)
                bfsGraph[j].append(i)
            }
        }
    }
    
    func bfs(_ start: Int, _ end: Int, graph: [[Int]]) -> Bool {
        var queue = [start]
        var visited = Array(repeating: false, count: end+1)
        visited[start] = true
        var index = 0
        
        while queue.count > index {
            let now = queue[index]
            index += 1
            
            if now == end {
                return true
            }
            
            for i in graph[now] {
                if !visited[i] {
                    visited[i] = true
                    queue.append(i)
                }
            }
        }
        return false
    }
    
    print(bfs(0, n+1, graph: bfsGraph) ? "happy" : "sad")
}
