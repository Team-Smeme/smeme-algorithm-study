//
//  boj_11399.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/02.
//
//  ATM
//  https://www.acmicpc.net/problem/11399

let number = Int(readLine()!)!
var array: [Int] = []
var time = 0
var result = 0

array = readLine()!.split(separator: " ").map{Int(String($0))!}
array.sort()

for i in array {
    time += i
    result += time
}

print(result)

// 메모리 : 69108 KB, 시간 : 8 ms
