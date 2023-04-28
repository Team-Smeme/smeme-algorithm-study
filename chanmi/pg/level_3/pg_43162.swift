//
//  pg_43162.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/28.
//
//  네트워크
//  https://school.programmers.co.kr/learn/courses/30/lessons/43162

import Foundation

func solution(_ n:Int, _ computers:[[Int]]) -> Int {
    let count = computers.count
    var result = 0
    var visited = Array(repeating: false, count: count)
    var index = 0
    var queue = [Int]()
    
    func bfs(_ start: Int) {
        queue.append(start)
        
        while queue.count > index {
            let now = queue[index]
            index += 1
            
            for i in 0..<count {
                if !visited[i] && now != i && computers[now][i] == 1 {
                    queue.append(i)
                    visited[i] = true
                }
            }
        }
    }
    
    for i in 0..<count {
        if !visited[i] {
            visited[i] = true
            bfs(i)
            result += 1
        }
    }
    
    return result
}

_ = solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]])
