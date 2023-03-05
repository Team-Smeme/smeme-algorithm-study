//
//  boj_14888.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/02/28.
//
//  연산자 끼워넣기
//  https://www.acmicpc.net/problem/14888

let input = Int(readLine()!)!
let number = readLine()!.split(separator: " ").map{Int(String($0))!}
let oper = readLine()!.split(separator: " ").map{Int(String($0))!}
var (sum, sub, mul, div) = (oper[0], oper[1], oper[2], oper[3])

var maxNumber = Int.min
var minNumber = Int.max

func backTracking(_ now: Int, _ depth: Int) {
    if input == depth {
        maxNumber = max(now, maxNumber)
        minNumber = min(now, minNumber)
    } else {
        if sum > 0 {
            sum -= 1
            backTracking(now+number[depth], depth+1)
            sum += 1
        }
        
        if sub > 0 {
            sub -= 1
            backTracking(now-number[depth], depth+1)
            sub += 1
        }
        
        if mul > 0 {
            mul -= 1
            backTracking(now*number[depth], depth+1)
            mul += 1
        }
        
        if div > 0 {
            div -= 1
            backTracking(now/number[depth], depth+1)
            div += 1
        }
    }
}

backTracking(number[0], 1)

print(maxNumber)
print(minNumber)

// 메모리 : 69104 KB, 시간 : 12 ms
