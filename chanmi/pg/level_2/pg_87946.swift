//
//  pg_87946.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/17.
//
//  피로도
//  https://school.programmers.co.kr/learn/courses/30/lessons/87946

import Foundation

func solution(_ k:Int, _ dungeons:[[Int]]) -> Int {
    let dungeonCount = dungeons.count
    var result = Int.min
    var visited = Array(repeating: false, count: dungeonCount)
    var k = k
    
    func dfs(_ start: Int, _ dungeonNumber: Int, _ count: Int) {
        result = max(result, count)
        
        for i in 0..<dungeonCount {
            if !visited[i] && k >= dungeons[i][0] {
                visited[i] = true
                k -= dungeons[i][1]
                dfs(k, i, count+1)
                k += dungeons[i][1]
                visited[i] = false
            }
        }
    }
    
    for i in 0..<dungeonCount {
        dfs(k, i, 0)
    }
    
    return result
}

_ = solution(80, [[80,20],[50,40],[30,10]])
