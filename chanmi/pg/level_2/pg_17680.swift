//
//  pg_17680.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/20.
//
//  2018 KAKAO BLIND RECRUITMENT - [1차] 캐시
//  https://school.programmers.co.kr/learn/courses/30/lessons/17680

import Foundation

func solution(_ cacheSize:Int, _ cities:[String]) -> Int {
    // LRU 알고리즘에 대해 확실하게 알고 있어야 함
    let cities = cities.map{ $0.uppercased() }
    var cache = [String]()
    var count = 0
    
    for city in cities {
        // 캐시 메모리에 도시가 이미 있을 때
        if cache.contains(city) {
            count += 1
            cache.remove(at: cache.firstIndex(of: city)!)
            cache.append(city)
        } else {
        // 도시가 없을 때
            count += 5
            cache.append(city)
            if cache.count > cacheSize {
                // 가장 안 쓰인 캐시를 제거해 줘야 함
                cache.removeFirst()
            }
        }
    }
    
    return count
}
