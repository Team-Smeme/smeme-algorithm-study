//
//  boj_1058.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/11.
//
//  친구
//  https://www.acmicpc.net/problem/1058
/*
    2-친구가 되는 조건
    1. A와 B가 친구이거나
    2. A와 친구이고 B와 친구인 C가 존재
 */

import Foundation

let N = Int(readLine()!)!
var array = Array(repeating: Array(repeating: 0, count: N), count: N)
var result = 0

var friend = [[String]]()
for _ in 0..<N {
    friend.append(readLine()!.map{String($0)})
}

for a in 0..<N {
    for b in 0..<N {
        for c in 0..<N {
            if b == c { continue }
            if friend[b][c] == "Y" || (friend[b][a] == "Y" && friend[a][c] == "Y") {
                array[b][c] = 1
            }
        }
    }
}

for i in 0..<N {
    var count = 0
    for j in 0..<N {
        if array[i][j] == 1 {
            count += 1
        }
    }
    result = max(result, count)
}

print(result)

// 메모리 : 79512 KB, 시간 : 16 ms
