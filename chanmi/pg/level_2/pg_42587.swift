//
//  pg_42587.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/14.
//
//  프린터
//  https://school.programmers.co.kr/learn/courses/30/lessons/42587

import Foundation

func solution(_ priorities:[Int], _ location:Int) -> Int {
    var priorities = priorities
    var location = location
    var count = 0
    
    while true {
        // 첫번째값이 제일 클 때
        if priorities.first! == priorities.max() {
            priorities.removeFirst()
            count += 1
            
            if location == 0 {
                break
            } else {
                location -= 1
            }
            // 첫번째값이 제일 크지 않을 때
        } else {
            let first = priorities.removeFirst()
            priorities.append(first)
            
            if location == 0 {
                location = priorities.count-1
            } else {
                location -= 1
            }
        }
    }
    
    return count
}

_ = solution([2, 1, 3, 2], 2)
