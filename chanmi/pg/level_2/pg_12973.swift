//
//  pg_12973.swift
//  algorithm
//
//  Created by 황찬미 on 2023/03/20.
//
//  짝지어 제거하기
//  https://school.programmers.co.kr/learn/courses/30/lessons/12973

import Foundation

func solution(_ s:String) -> Int{
    if s.count % 2 != 0 { return 0 }
    
    let s = Array(s)
    var stack = [Character]()
    
    for i in s {
        if let top = stack.last, top == i {
            stack.removeLast()
        } else {
            stack.append(i)
        }
    }
    
    return stack.isEmpty ? 1 : 0
}

print(solution("baabaa"))
