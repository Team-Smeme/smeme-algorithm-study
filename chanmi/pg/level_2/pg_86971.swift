//
//  pg_86971.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/13.
//
//  전력망을 둘로 나누기
//  https://school.programmers.co.kr/learn/courses/30/lessons/86971

/*
 간선이 끊어지는 bfs 함수를 처음에 abs(bfs(a)-(n-bfs(a))) 이렇게 사용했는데
 그러면 bfs 함수가 두 번 돌게 된다...
 bfs 함수를 돌린 변수를 선언해 줘서 한 번만 호출해 준 다음 그 변수값으로 result를 계산해 줬다
 */

import Foundation

func solution(_ n:Int, _ wires:[[Int]]) -> Int {
    var tree = Array(repeating: Array(repeating: 0, count: 0), count: n+1)
    tree[0].append(0)
    
    var visited = Array(repeating: false, count: n+1)
    
    // 트리 연결
    for wire in wires {
        tree[wire[0]].append(wire[1])
        tree[wire[1]].append(wire[0])
    }
    
    var queue = [Int]()
    var index = 0
    
    func bfs(_ start: Int) -> Int {
        var count = 0
        queue.append(start)
        visited[start] = true
        
        while queue.count > index {
            let node = queue[index]
            index += 1
            count += 1
            
            for i in tree[node] {
                if !visited[i] {
                    visited[i] = true
                    queue.append(i)
                }
            }
        }
        return count
    }
    
    var result = Int.max
    
    for wire in wires {
        visited = Array(repeating: false, count: n+1)
        let (a, b) = (wire[0], wire[1])
        
        // 간선 끊어 주기
        visited[b] = true
        
        let revokeNode = bfs(a)
        result = min(result, abs(revokeNode-(n-revokeNode)))
    }
    return result
}
