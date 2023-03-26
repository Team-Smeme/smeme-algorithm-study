//
//  boj_2580.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/03/21.
//
//  스도쿠
//  https://www.acmicpc.net/problem/2580

var row = Array(repeating: Array(repeating: false, count: 10), count: 10)
var col = Array(repeating: Array(repeating: false, count: 10), count: 10)
var rect = Array(repeating: Array(repeating: false, count: 10), count: 10)
var graph = Array(repeating: Array(repeating: 0, count: 9), count: 9)
var flag = false

for i in 0..<9 {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    
    for j in 0..<9 {
        graph[i][j] = input[j]
        if graph[i][j] > 0 {
            let num = graph[i][j]
            row[i][num] = true
            col[j][num] = true
            rect[(i/3)*3+(j/3)][num] = true
        }
    }
}

func backTracking(_ start: Int) {
    if flag { return }
    let x = start/9
    let y = start%9
    
    if start == 81 {
        for i in graph {
            for j in i {
                print(j, terminator: " ")
            }
            print()
        }
        flag = true
        return
    }
    
    if graph[x][y] > 0 {
        backTracking(start+1)
    } else {
        for i in 1...9 {
            if !row[x][i] && !col[y][i] && !rect[(x/3)*3+(y/3)][i] {
                row[x][i] = true
                col[y][i] = true
                rect[(x/3)*3+(y/3)][i] = true
                graph[x][y] = i
                backTracking(start+1)
                row[x][i] = false
                col[y][i] = false
                rect[(x/3)*3+(y/3)][i] = false
                graph[x][y] = 0
            }
        }
    }
}

backTracking(0)

// 메모리 : 69108 KB, 시간 : 680 ms
