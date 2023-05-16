//
//  pg_17677.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/16.
//
//  [1차] 뉴스 클러스터링
//  https://school.programmers.co.kr/learn/courses/30/lessons/17677

import Foundation

func solution(_ str1:String, _ str2:String) -> Int {
    
    // 입력값들을 전부 대문자로 바꾼다
    
    let upStr1 = str1.uppercased()
    let upStr2 = str2.uppercased()
    
    var str1Arr = [String]()
    var str2Arr = [String]()
    
    var tempStr1 = ""
    var tempStr2 = ""
    
    // 배열에 추가
    
    for i in 0..<upStr1.count-1 {
        let first = upStr1[upStr1.index(upStr1.startIndex, offsetBy: i)]
        let second = upStr1[upStr1.index(upStr1.startIndex, offsetBy: i+1)]
        var word = ""
        
        if first.isLetter && second.isLetter {
            word = String(first)+String(second)
            str1Arr.append(word)
        }
    }
    
    for i in 0..<upStr2.count-1 {
        let first = upStr2[upStr2.index(upStr2.startIndex, offsetBy: i)]
        let second = upStr2[upStr2.index(upStr2.startIndex, offsetBy: i+1)]
        var word = ""
        
        if first.isLetter && second.isLetter {
            word = String(first)+String(second)
            str2Arr.append(word)
        }
    }
    
    // intersection, union 함수
    
    func createIntersection(_ arr1: [String], _ arr2: [String]) -> [String] {
        var result: [String] = []
        
        var temp = arr2
        arr1.forEach {
            if let index = temp.firstIndex(of: $0) {
                temp.remove(at: index)
                result.append($0)
            }
        }
        return result
    }
    
    func createUnion(_ arr1: [String], _ arr2: [String]) -> [String] {
        var result: [String] = []
        
        var temp = arr2
        arr1.forEach {
            if let index = temp.firstIndex(of: $0) {
                temp.remove(at: index)
            }
        }
        result.append(contentsOf: arr1)
        result.append(contentsOf: temp)
        
        return result
    }
    
    let interCount = Double(createIntersection(str1Arr, str2Arr).count)
    let unionCount = Double(createUnion(str1Arr, str2Arr).count)
    
    let number: Double = 65536
    var result = 1.0
    
    if interCount == 0.0 && unionCount == 0.0 {
        return Int(number)
    }

    return Int((interCount/unionCount)*number)
}

_ = solution(aa1+aa2, AAAA12)
