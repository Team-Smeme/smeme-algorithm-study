//
//  pg_17679.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/04/20.
//
//  2018 KAKAO BLIND RECRUITMENT - [1차] 프렌즈4블록
//  https://school.programmers.co.kr/learn/courses/30/lessons/17679

/*
 다 풀었는데 인덱스 실수해서 시간 좀 잡아먹었던 문제...
 블럭을 삭제하고 옮겨 주는 구현 과정을 좀 더 공부해 보면 좋을 것 같다
 */

func solution(_ m:Int, _ n:Int, _ board:[String]) -> Int {
    var visited = Array(repeating: Array(repeating: false, count: n), count: m)
    var newBoard = Array(repeating: [String](), count: m)
    var count = 0
    
    for i in 0..<board.count {
        newBoard[i] = board[i].map{String($0)}
    }
    
    func deleteBlock(_ board: [[String]]) {
        for i in 0..<m {
            for j in 0..<n {
                if visited[i][j] {
                    newBoard[i][j] = "."
                }
            }
        }
    }
    
    func moveBlock(_ board: [[String]]) {
        // 밑에서부터 남은 공간을 채워 준다
        for i in 0..<n {
            var queue = [String]()
            for j in stride(from: m-1, through: 0, by: -1) {
                if newBoard[j][i] != "." {
                    queue.append(newBoard[j][i])
                    newBoard[j][i] = "."
                }
            }
            
            for j in stride(from: m-1, through: 0, by: -1) {
                if !queue.isEmpty {
                    let removeBlock = queue.removeFirst()
                    newBoard[j][i] = removeBlock
                } else {
                    break
                }
            }
        }
    }
    
    // 삭제될 블럭이 없다면 빠져나오기
    while true {
        var flag = false
        for i in 0...m-2 {
            for j in 0...n-2 {
                let word = newBoard[i][j]
                // 주의
                if word == "." { continue }
                if word == newBoard[i][j+1] && word == newBoard[i+1][j] && word == newBoard[i+1][j+1] {
                    flag = true
                    if !visited[i][j] {
                        visited[i][j] = true
                        count += 1
                    }
                
                    if !visited[i][j+1] {
                        visited[i][j+1] = true
                        count += 1
                    }
                
                    if !visited[i+1][j] {
                        visited[i+1][j] = true
                        count += 1
                    }
                
                    if !visited[i+1][j+1] {
                        visited[i+1][j+1] = true
                        count += 1
                    }
                }
            }
        }
        
        // 더이상 지워질 것이 없을 때
        if !flag {
            break
        }
        
        // 조건 충족된 블록들 삭제해 주기
        deleteBlock(newBoard)
        moveBlock(newBoard)
        // 방문 초기화
        visited = Array(repeating: Array(repeating: false, count: n), count: m)
    }
    
    return count
}

_ = solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"])
