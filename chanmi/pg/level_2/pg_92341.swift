//
//  pg_92341.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/06/05.
//
//  주차 요금 계산 - 2022 KAKAO BLIND RECRUITMENT
//  https://school.programmers.co.kr/learn/courses/30/lessons/92341

import Foundation

func solution(_ fees:[Int], _ records:[String]) -> [Int] {
        
    func addLastTimeRecords() {
        let endTime = "23:59"
        
        for (key, value) in dic {
            if value.count % 2 != 0 {
                dic[key]?.append((time: endTime, state: "OUT"))
            }
        }
    }
    
    func calculateTime(_ dic: [String: [(time: String, state: String)]]) {
        let basicTime = fees[0]
        let basicCost = fees[1]
        let addTime = fees[2]
        let addCost = fees[3]
        
        for (key, value) in dic {
            var sumTime = 0
            for i in stride(from: 0, through: value.count-2, by: 2) {
                let firstValue = value[i]
                let secondValue = value[i+1]

                let splitFirst = firstValue.time.split(separator: ":").map{Int($0)}
                let splitSecond = secondValue.time.split(separator: ":").map{Int($0)}
                
                let firstStartHours = Int(splitFirst[0]!)
                let firstStartMinute = Int(splitFirst[1]!)
                
                let secondEndHours = Int(splitSecond[0]!)
                let secondEndMinute = Int(splitSecond[1]!)
                
                sumTime += (secondEndHours-firstStartHours)*60 + secondEndMinute-firstStartMinute
            }
            
            if sumTime > basicTime {
                let ceilNumber = Int(ceil(Double(sumTime-basicTime)/Double(addTime)))
                let resultCost = basicCost+ceilNumber*addCost
                calculateTimeArray.append((carNumber: key, cost: resultCost))
            } else {
                calculateTimeArray.append((carNumber: key, cost: basicCost))
            }
        }
    }
    
    var dic = [String: [(time: String, state: String)]]()
    
    for i in records {
        let splitStr = i.split(separator: " ").map{String($0)}
        
        let time = splitStr[0]
        let carNumber = splitStr[1]
        let state = splitStr[2]
        
        // 초기값일 때
        guard let _ = dic[carNumber] else {
            dic[carNumber] = [(time: time, state: state)]
            continue
        }

        dic[carNumber]?.append((time: time, state: state))
    }
    
    addLastTimeRecords()
    
    var calculateTimeArray = [(carNumber: String, cost: Int)]()
    
    calculateTime(dic)
    
    let resultArray = calculateTimeArray.sorted {
        return $0.carNumber < $1.carNumber
    }.map {
        $0.cost
    }
    
    return resultArray
}

print(solution([180, 5000, 10, 600],
               ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))
