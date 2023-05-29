//
//  boj_9935.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/30.
//
//  문자열 폭발
//  https://www.acmicpc.net/problem/9935

let string = String(readLine()!)
let target = String(readLine()!)
var stack = [Character]()

for char in string {
    stack.append(char)
        if stack.last! == target.last! && stack.count >= target.count && target == String(stack[stack.count-target.count..<stack.count]) {
            for _ in 0..<target.count {
                stack.removeLast()
        }
    }
}

stack.isEmpty ? print("FRULA") : print(String(stack))

// 94712 KB, 시간 : 400 ms
