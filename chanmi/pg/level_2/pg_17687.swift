//
//  pg_17687.swift
//  algorithm
//
//  Created by 황찬미 on 2023/04/22.
//
//  2018 KAKAO BLIND RECRUITMENT - [3차] n진수 게임
//  https://school.programmers.co.kr/learn/courses/30/lessons/17687

func solution(_ n:Int, _ t:Int, _ m:Int, _ p:Int) -> String {
    var totalNumber = t*m
    var string = ""
    
    for i in 0..<totalNumber {
        string += String(i, radix: n, uppercase: true)
    }
    
    let array = Array(string)
    var result = ""
    var index = 0
    
    while result.count != t {
        for i in 1...m {
            if i == p {
                result += String(array[index])
            }
            index += 1
        }
    }
    return result
}

_ = solution(2, 4, 2, 1, "0111")
