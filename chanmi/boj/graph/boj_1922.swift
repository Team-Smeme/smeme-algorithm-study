//
//  boj_1922.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/08.
//
//  네트워크 연결 (크루스칼 알고리즘)
//  https://www.acmicpc.net/problem/1922

let N = Int(readLine()!)!
let M = Int(readLine()!)!

var parent = Array(repeating: 0, count: N+1)
var computers = [[Int]]()

for i in 1..<N+1 {
    parent[i] = i
}

for _ in 0..<M {
    computers.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}

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

var result = 0
let sortedComputers = computers.sorted { $0[2] < $1[2] }

for computer in sortedComputers {
    if findParent(computer[0]) != findParent(computer[1]) {
        union(computer[0], computer[1])
        result += computer[2]
    }
}

print(result)

// 메모리 : 77732 KB, 시간 : 204 ms
