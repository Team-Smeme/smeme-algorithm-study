//
//  pg_76502.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/03.
//
//  괄호 회전하기
//  https://school.programmers.co.kr/learn/courses/30/lessons/76502

func solution(_ s:String) -> Int {
    var sCount = s.count
    var s = s.map{String($0)}
    var count = 0
    var stack = [String]()
    
    for _ in 0..<sCount {
        var flag = true
        
        // 회전된 문자열 탐색
        for j in 0..<sCount {
            if (stack.isEmpty && (s[j] == ")" || s[j] == "]" || s[j] == "}")) {
                flag = false
                break
            } else if s[j] == "(" || s[j] == "[" || s[j] == "{" {
                stack.append(s[j])
            } else {
                if s[j] == ")" && stack.last == "(" {
                    stack.removeLast()
                } else if s[j] == "]" && stack.last == "[" {
                    stack.removeLast()
                } else if s[j] == "}" && stack.last == "{" {
                    stack.removeLast()
                } else {
                    flag = false
                    break
                }
            }
        }
        
        // 문자열을 전부 탐색했지만, 스택이 비어 있지 않을 경우
        if !stack.isEmpty {
            flag = false
        }
        
        if flag {
            count += 1
        }
        
        let first = s.removeFirst()
        s.append(first)
    }
    
    return count
}
