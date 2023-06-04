//
//  pg_17686.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/06/05.
//
//  [3차] 파일명 정렬 - 2018 KAKAO BLIND RECRUITMENT
//  https://school.programmers.co.kr/learn/courses/30/lessons/17686

func solution(_ files:[String]) -> [String] {
    let uppercaseFiles = files.map{ $0.uppercased() }
    var array = [(total: String, originTotal: String, index: Int, head: String,
                  number: Int)]()
    
    for (index, uppercaseFile) in uppercaseFiles.enumerated() {
        let originTotalFile = files[index]
        var headStr = ""
        var numberStr = ""
        
        for i in uppercaseFile {
            let i = String(i)
            if headStr != "" && numberStr != "" && Int(i) == nil { break }
            if let temp = Int(i) {
                numberStr += String(temp)
                continue
            }
            
            headStr += i
        }
        print(Int(numberStr)!)
        
        array.append((total: uppercaseFile, originTotal: originTotalFile, index: index, head: headStr, number: Int(numberStr)!))
    }
    
    let sortedArray = array.sorted {
        if $0.head == $1.head {
            if $0.number == $1.number {
                return $0.index < $1.index
            }
            return $0.number < $1.number
        }
        return $0.head < $1.head
    }.map{
        $0.originTotal
    }
    
    return sortedArray
}

print(solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]))
