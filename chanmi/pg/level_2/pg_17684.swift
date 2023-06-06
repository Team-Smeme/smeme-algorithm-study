//
//  pg_17684.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/06/02.
//
//  3차 [압축]
//  https://school.programmers.co.kr/learn/courses/30/lessons/17684

func solution(_ msg:String) -> [Int] {
    var dic = ["A": 1, "B": 2, "C": 3, "D": 4, "E": 5, "F": 6, "G": 7,
               "H": 8, "I": 9, "J": 10, "K": 11, "L": 12, "M": 13,
               "N": 14, "O": 15, "P": 16, "Q": 17, "R": 18, "S": 19,
               "T": 20, "U": 21, "V": 22, "W": 23, "X": 24, "Y": 25,
               "Z": 26]
    
    var result = [Int]()
    let count = msg.count
    var i = 0
    let msg = msg.map{String($0)}
    var str = ""
    var number = 26
    
    while i < count {
        let nowStr = msg[i]
        let nextStr = str+nowStr
        
        // 사전에 없는 값이라면 사전에 추가
        guard let temp = dic[nextStr] else {
            number += 1
            dic[nextStr, default: number] = number
            result.append(dic[str]!)
            
            str = ""
            continue
        }
        
        // 사전에 있다면 계속 탐색
        i += 1
        str += nowStr
    }
    
    result.append(dic[str]!)
    
    return result
}

_ = solution("KAKAO")
