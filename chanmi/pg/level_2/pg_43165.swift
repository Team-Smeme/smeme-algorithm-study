//
//  pg_43165.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/18.
//
//  타겟 넘버
//  https://school.programmers.co.kr/learn/courses/30/lessons/43165

import Foundation

func solution(_ numbers:[Int], _ target:Int) -> Int {
    var count = numbers.count
    var visited = Array(repeating: false, count: count)
    var result = 0
    
    // 첫번째 방법
    func dfs(_ start: Int, _ depth: Int) {
        if depth == count {
            if start == target {
                result += 1
            }
            return
        }
            dfs(start-numbers[depth], depth+1)
            dfs(start+numbers[depth], depth+1)
        }
    
    dfs(0, 0)
    
    func bfs(_ number: Int) {
        var result = 0
        
        for num in numbers {
        
        }
    }
    
    return result
}
