//
//  boj_11055.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/12.
//
//  가장 긴 증가하는 부분 수열
//  https://www.acmicpc.net/problem/11055

let input = Int(readLine()!)!
var array = [Int]()

array = readLine()!.split(separator: " ").map{Int(String($0))!}

var dp = array

for i in 0..<input {
    for j in 0..<i {
        if array[j] < array[i] {
            dp[i] = max(dp[i], dp[j]+array[i])
        }
    }
}

print(dp.max()!)

