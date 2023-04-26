//
//  pg_12951.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/27.
//
//  JadenCase 문자열 만들기
//  https://school.programmers.co.kr/learn/courses/30/lessons/12951

func solution(_ s:String) -> String {
    var result = ""
    let arrayStr = s.map{String($0)}
    
    for str in 0..<arrayStr.count {
        // index error 방지
        if str == 0 {
            if arrayStr[str] == " " {
                result += arrayStr[str]
            } else {
                if let number = Int(arrayStr[str]) {
                    result += String(number)
                    continue
                }
                result += arrayStr[str].uppercased()
            }
        } else {
            if arrayStr[str] == " " {
                result += arrayStr[str]
            } else {
                if arrayStr[str-1] == " " {
                    result += arrayStr[str].uppercased()
                } else {
                    result += arrayStr[str].lowercased()
                }
            }
        }
    }
    return result
}

_ = solution("3people unFollowed me")

// 좀 더 보완해 본 풀이 - 애초에 앞의 문자가 숫자이든, 알파벳이든 분기 처리 해 줄 필요가 없다

func solution(_ s:String) -> String {
    var result = ""
    let arrayStr = s.map{String($0)}
    var index = 0
    
    for str in arrayStr {
        if str != " " {
            if index == 0 {
                result += str.uppercased()
            } else {
                result += str.lowercased()
            }
            index += 1
        } else {
            result += str
            index = 0
        }
    }
    return result
}
