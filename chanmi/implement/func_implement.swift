//
//  func_implement.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/05/12.
//

/*
 배열 arr 안의 숫자들 중에서 앞에 있는 숫자들부터 뒤에 중복되어 나타나는 숫자들 중복 횟수를 계산해서 return 하는 solution 함수 구현. 만약 중복되는 숫자가 없다면 -1 return
 
 - 입출력 예시
 array = [1, 2, 3, 3, 3, 3, 4, 4], return [4, 3]
 array = [3, 2, 4, 4, 2, 5, 2, 5, 5], return [3, 2, 3]
 array = [3, 5, 7, 9, 1], return -1
 
 제한 사항 : array 길이 1 이상 100 이하, array 원소 크기 동일
 */

/*
 1. 문제를 해결하기 위한 함수를 선언할 수 있어야 함
 2. 함수 내부에서 배열을 탐색할 수 있어야 함.
 3. 배열 앞뒤 값을 비교하고, 중복되는 횟수를 count하면서 변경할 수 있어야 함.
 4. 배열과 다른 Set, Dictionary 타입을 활용하여 비교할 수 있어야 함.
 */

func solution_Version_Dictionary(_ array: [Int]) -> [Int] {
    var dic = [Int:(order: Int, count: Int)]()
    
    func sameValueCount(_ array: [Int]) {
        var order = 1
        for i in 0..<array.count {
            let number = array[i]
            
            if let temp = dic[number] {
                dic[number] = (order: temp.0, count: temp.1+1)
                continue
            }
            
            dic[number, default: (0, 0)] = (order: order, count: 1)
            order += 1
        }
    }
    
    sameValueCount(array)
    
    let resultArray = dic.filter { $0.value.1 > 1 }.sorted(by: { $0.value.order < $1.value.order}).map{ $0.value.count }
    
    return resultArray.isEmpty ? [-1] : resultArray
}

print(solution_Version_Dictionary([1, 2, 3, 3, 3, 3, 4, 4])) // [4, 2]
print(solution_Version_Dictionary([3, 2, 4, 4, 2, 5, 2, 5, 5])) // [3, 2, 3]
print(solution_Version_Dictionary([3, 5, 7, 9, 1])) // [-1]

func solution_Version_Set(_ array: [Int]) -> [Int] {
    var set: Set<Int> = []
    var orderAndCountArray = Array(repeating: (order: 0, count: 0), count: 101)
    
    func sameValueCount(_ array: [Int]) {
        var order = 1
        for i in 0..<array.count {
            let number = array[i]
            
            if let temp = set.update(with: number) {
                let (tempOrder, tempCount) = orderAndCountArray[temp]
                orderAndCountArray[temp] = (order: tempOrder, count: tempCount+1)
                continue
            }
            orderAndCountArray[number] = (order: order, count: 1)
            order += 1
        }
    }
    
    sameValueCount(array)
    
    let resultArray = orderAndCountArray.filter { $0.count > 1 }.sorted(by: { $0.order < $1.order }).map{ $0.count }

    return resultArray.isEmpty ? [-1] : resultArray
}

print(solution_Version_Set([1, 2, 3, 3, 3, 3, 4, 4])) // [4, 2]
print(solution_Version_Set([3, 2, 4, 4, 2, 5, 2, 5, 5])) // [3, 2, 3]
print(solution_Version_Set([3, 5, 7, 9, 1])) // [-1]
