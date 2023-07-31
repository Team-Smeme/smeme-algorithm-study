//
//  pg_12911.swift
//  algorithm
//
//  Created by 황찬미 on 2023/03/22.
//
//  다음 큰 숫자
//  https://school.programmers.co.kr/learn/courses/30/lessons/12911

import Foundation

func solution(_ n:Int) -> Int {
    var n = n
    let radixN = String(n, radix: 2)
    var count = 0
    
    for i in radixN {
        if i == "1" {
            count += 1
        }
    }
    
    while true {
        n += 1
        let radixNumber = String(n, radix: 2)
        var bigNumberCount = 0
        
        for i in radixNumber {
            if i == "1" {
                bigNumberCount += 1
            }
        }
        
        if count == bigNumberCount {
            return n
        }
    }
    
    return n
}

_ = solution(78)
