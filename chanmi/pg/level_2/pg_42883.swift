//
//  pg_42883.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/10.
//
//  큰 수 만들기
//  https://school.programmers.co.kr/learn/courses/30/lessons/42883

func solution(_ number:String, _ k:Int) -> String {
    let number = number
    let numberArray = number.map{Int(String($0))!}
    var stack = [Int]()
    var removeCount = 0
    
    for i in numberArray {
        while !stack.isEmpty && removeCount < k && stack.last! < i {
            stack.removeLast()
            removeCount += 1
        }
        stack.append(i)
    }
    
    // 인덱스를 끝까지 돌았는데도 k만큼의 개수를 제거하지 못했다면
    while stack.count > numberArray.count-k {
        stack.removeLast()
    }
    
    return stack.map{String($0)}.joined(separator:"")
}

print(solution("1231234", 3))

// 예외 처리 꼼꼼하게...
