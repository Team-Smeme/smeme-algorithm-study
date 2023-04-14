//
//  pg_42586.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/14.
//
//  기능개발
//  https://school.programmers.co.kr/learn/courses/30/lessons/42586

import Foundation

func solution(_ progresses:[Int], _ speeds:[Int]) -> [Int] {
    var progresses = progresses
    var speeds = speeds
    var result = [Int]()
    var index = 0
    
    while true {
        if index >= progresses.count {
            break
        } else {
            // 여기는 값이 있음을 보장되기 때문에 괜춘
            if progresses[index] < 100 {
                for i in index..<progresses.count {
                    progresses[i] = progresses[i]+speeds[i]
                }
            } else {
                var count = 0
                while progresses[index] >= 100 && index < progresses.count {
                    index += 1
                    count += 1
                }
                result.append(count)
            }
        }
    }
    return result
}

_ = solution([93, 30, 55], [1, 30, 5])
