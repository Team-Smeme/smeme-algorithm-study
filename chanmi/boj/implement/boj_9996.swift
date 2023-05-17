//
//  boj_9996.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/16.
//
//  한국이 그리울 땐 서버에 접속하지
//  https://www.acmicpc.net/problem/9996

let input = Int(readLine()!)!
let pattern = readLine()!

let firstChr = String(pattern.split(separator: "*")[0])
let secondChr = String(pattern.split(separator: "*")[1])

var array = [String]()

for _ in 0..<input {
    array.append(readLine()!)
}

for str in array {
    if firstChr.count + secondChr.count > str.count {
        print("NE")
    } else if str.hasPrefix(firstChr) == true && str.hasSuffix(secondChr) == true {
        print("DA")
    } else {
        print("NE")
    }
}
