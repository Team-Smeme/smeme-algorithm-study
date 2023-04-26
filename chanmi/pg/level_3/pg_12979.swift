//
//  pg_12979.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/24.
//
//  기지국 설치
//  https://school.programmers.co.kr/learn/courses/30/lessons/12979

import Foundation

func solution(_ n:Int, _ stations:[Int], _ w:Int) -> Int{
    var result = 0
    var start = 1
    
    // w*2+1 공식 이용
    for station in stations {
        result += Int(ceil(Double(station-w-start)/Double(2*w+1)))
        start = station+w+1
    }
    
    // 끝부분이 남은 경우
    if start <= n {
        result += Int(ceil(Double(n-start+1)/Double(2*w+1)))
    }

    return result
}

_ = solution(11, [4, 11], 1)
