//
//  pg_87377.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/11.
//
//  교점에 별 만들기
//  https://school.programmers.co.kr/learn/courses/30/lessons/87377

import Foundation

func solution(_ line:[[Int]]) -> [String] {
    var maxX = Int.min
    var minX = Int.max
    var maxY = Int.min
    var minY = Int.max
    
    var array = [(Int, Int)]()
    
    // 좌표 계산
    for first in 0..<line.count-1 {
        for second in first+1..<line.count {
            let abe = line[first]
            let cdf = line[second]
            
            let ad = abe[0]*cdf[1]
            let bc = abe[1]*cdf[0]
            let bf = abe[1]*cdf[2]
            let ed = abe[2]*cdf[1]
            let ec = abe[2]*cdf[0]
            let af = abe[0]*cdf[2]
            
            let adbc = ad-bc
            let bfed = bf-ed
            let ecaf = ec-af
            
            if adbc != 0 && bfed%adbc == 0 && ecaf%adbc == 0 {
                array.append((bfed/adbc, ecaf/adbc))
                
                // 최대, 최소 좌표 갱신
                maxX = max(maxX, array.last!.0)
                minX = min(minX, array.last!.0)
                maxY = max(maxY, array.last!.1)
                minY = min(minY, array.last!.1)
            }
        }
    }
    
    // 좌표 만들기
    var starArray = Array(repeating: Array(repeating: ".", count: maxX-minX+1), count: maxY-minY+1)
    
    // 좌표 그리기
    for i in array {
        starArray[i.1-minY][i.0-minX] = "*"
    }
    
    var resultArray = [String]()
    
    for line in starArray {
        resultArray.append(line.joined(separator: ""))
    }

    return resultArray.reversed()
}
