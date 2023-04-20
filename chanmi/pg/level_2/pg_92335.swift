//
//  pg_92335.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/14.
//
//  k진수에서 소수 개수 구하기 (2022 KAKAO BLIND RECRUITMENT)
//  https://school.programmers.co.kr/learn/courses/30/lessons/92335

import Foundation

func solution(_ n:Int, _ k:Int) -> Int {
    let changeNumber = String(n, radix: k)
    let splitArray = changeNumber.split(separator: "0").filter{ $0 != "1" }.map{ String($0) }
    var count = 0
    
    func isPrime(_ n: String) -> Bool {
        let isCheckedPrime = Int(n)!
        
        if isCheckedPrime < 4 {
            return true
        } else {
            for i in 2...Int(sqrt(Double(isCheckedPrime))) {
                if isCheckedPrime % i == 0 {
                    return false
                }
            }
            return true
        }
    }
    
    for i in splitArray {
        if isPrime(i) {
            count += 1
        }
    }
    
    return count
}
