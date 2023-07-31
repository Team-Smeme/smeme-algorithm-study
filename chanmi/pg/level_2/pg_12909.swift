//
//  pg_12909.swift
//  algorithm
//
//  Created by 황찬미 on 2023/03/16.
//
//  올바른 괄호
//  https://school.programmers.co.kr/learn/courses/30/lessons/12909

/*
 효율성 테스트 때문에, 스택이 아닌 int형 변수로 횟수 count 해 준 문제
 */

import Foundation

func solution(_ s:String) -> Bool {
    var ans: Bool = false
    var count = 0
    
    for i in s {
        if i == "(" {
            count += 1
        } else if i == ")" && count > 0 {
            count -= 1
        } else {
            return ans
        }
    }
    
    return count == 0 ? true : ans
}

_ = solution("()()")
