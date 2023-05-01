//
//  pg_12904.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/01.
//
//  가장 긴 팰린드롬
//  https://school.programmers.co.kr/learn/courses/30/lessons/12904

import Foundation

// DP

func solution(_ s:String) -> Int {
    let number = s.count
    var dp = Array(repeating: Array(repeating: false, count: number+1), count: number+1)
    var result = 1
    let s = s.map{String($0)}
    
    if number == 1 { return 1 }
    
    // 길이가 1인 팰린드롬
    for i in 0..<number {
        dp[i][i] = true
    }
    
    // 길이가 2인 팰린드롬
    for i in 0..<number-1 {
        if s[i] == s[i+1] {
            dp[i][i+1] = true
            result = 2
        }
    }
    
    if s.count == 2 { return result }
    
    // 길이가 3 이상인 모든 팰린드롬
    for len in 3...number {
        for i in 0...number-len {
            let j = i + len - 1
            if s[i] == s[j] && dp[i+1][j-1] {
                dp[i][j] = true
                result = max(result, len)
            }
        }
    }
    
    // len은 검사할 부분 문자열의 길이
    // i는 부분 문자열의 시작 인덱스
    // j는 부분 문자열의 마지막 인덱스
    // i+1부터 j-1까지의 부분 문자열이 팰린드롬이어야 dp[i][j] = true가 성립함
    
    return result
}

_ = solution("abacde")

// 완전탐색

func solution2(_ s:String) -> Int {
    var result = 0
    let s = s.map{String($0)}
    
    for i in 0..<s.count {
        for j in stride(from: s.count-i, to: result, by: -1) {
            var left = i
            var right = i+j-1
            
            print("left", left)
            print("right", right)
            
            while left <= right && s[left] == s[right] {
                left += 1
                right -= 1
            }
            
            if left > right { result = max(result, j) }
        }
    }
    return result
}

_ = solution2("abacde")
