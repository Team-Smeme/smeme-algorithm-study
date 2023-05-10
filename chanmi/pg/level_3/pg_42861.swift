//
//  pg_42861.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/07.
//
//  섬 연결하기
//  https://school.programmers.co.kr/learn/courses/30/lessons/42861

import Foundation

func solution(_ n:Int, _ costs:[[Int]]) -> Int {
    func findParent(_ node: Int) -> Int {
        if parent[node] != node {
            return findParent(parent[node])
        } else {
            return node
        }
    }
    
    func union(_ a: Int, _ b: Int) {
        let a = findParent(a)
        let b = findParent(b)
        
        if a < b {
            parent[b] = a
        } else {
            parent[a] = b
        }
    }
    
    var parent = Array(repeating: 0, count: n+1)
    
    for i in 1..<n+1 {
        parent[i] = i
    }
    
    var result = 0
    let sortedCosts = costs.sorted { $0[2] < $1[2] }

    for node in sortedCosts {
        if findParent(node[0]) != findParent(node[1]) {
            union(node[0], node[1])
            result += node[2]
        }
    }
    return result
}

_ = solution(4, [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]])
