//
//  byte_padding.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/06/07.
//

/*
 타입별 메모리 크기
 
 - 배열에 포함된 문자열을 비교해서 적합한 값으로 변환할 수 있어야 한다.
 - 특정 조건에 대한 예외처리 추가할 수 있어야 한다.
 - 반복문 흐름 제어를 하면서 종료 조건을 적용할 수 있어야 한다.
 - 스스로 다양한 케이스를 예상하고 검증해 볼 수 있어야 한다.
 
 BOOL - 1바이트
 SHORT - 2바이트
 FLOAT - 4바이트
 INT - 8바이트
 LONG - 16바이트
 
 입력한 순서대로 메모리를 할당한 결과를 8바이트 단위로 구분해서 return 해주는 함수 작성
 단, BOOL을 제외한 8바이트보다 작은 타입들이 연속될 경우에는 사이에 패딩(.)을 붙여야 한다.
 SHORT 2배수, FLOAT 4배수가 되도록 메모리 할당.
 
 < 제한 사항 >
 - 입력 타입은 1개 이상, 100개 이하까지만 가능
 - 출력하는 메모리 최대 크기는 128 바이트를 기준으로 동작. 따라서 128보다 큰 메모리는 할당 불가.
 - 만약 타입 하나라도 더이상 할당할 수 없는 경우는 "HALT"를 리턴.
 */

func bytePadding(_ array: [String]) -> String {
    var now = 0
    var result = ""
    var tempStr = [".", ".", ".", ".", ".", ".", ".", ".", ","]
    var moveByte = 0
    var flag = false
    
    func initValue() {
        result += tempStr.joined(separator: "")
        now = 0
        tempStr = [".", ".", ".", ".", ".", ".", ".", ".", ","]
        moveByte = 0
    }
    
    for str in array {
        if str == "INT" {
            if now != 0 {
                initValue()
            }
            
            result += "########,"
        } else if str == "LONG" {
            if now != 0 {
                initValue()
            }
            result += "########,########,"
        } else {
            if now > 7 {
                initValue()
            }
            
            if str == "BOOL" {
                tempStr[now] = "#"
                now += 1
            } else if str == "SHORT" {
                for i in stride(from: 0, through: tempStr.count-2, by: 2) {
                    let first = tempStr[i]
                    let second = tempStr[i+1]
                    
                    if (first == ".") && (second == ".") {
                        tempStr[i] = "#"
                        tempStr[i+1] = "#"
                        
                        now += 2
                        
                        if now % 2 != 0 {
                            now += 1
                        }
                        break
                    }
                }
            } else if str == "FLOAT" {
                for i in stride(from: 0, through: tempStr.count-2, by: 4) {
                    let first = tempStr[i]
                    let second = tempStr[i+1]
                    let third = tempStr[i+2]
                    let four = tempStr[i+3]
                    
                    if (first == ".") && (second == ".") && (third == ".") && (four == ".") {
                        tempStr[i] = "#"
                        tempStr[i+1] = "#"
                        tempStr[i+2] = "#"
                        tempStr[i+3] = "#"
                        
                        now += 4
                        if flag {
                            now += 4-moveByte+1
                        }
                        moveByte = 0
                        break
                    }
                }
            }
            
            // 현재 메모리의 비트 개수와 비트가 있다는 bool값
            if tempStr.contains("#") {
                moveByte += 1
                flag = true
            }
            
            // 현재 메모리가 모두 채워졌을 때
            if tempStr[8] == "#" {
                initValue()
            }
        }
    }
    
    // 메모리에 추가해야 될 값이 남았을 때
    if tempStr.contains("#") {
        result += tempStr.joined(separator: "")
    }
    
    // 128 바이트를 초과했을 때
    if result.count > 128 { return "HALT"}
    
    result.removeLast(1)
    
    return result
}

print(bytePadding(["INT", "INT", "BOOL", "SHORT", "LONG"]))
print(bytePadding(["INT", "SHORT", "FLOAT", "INT", "BOOL"]))
print(bytePadding(["FLOAT", "SHORT", "BOOL", "BOOL", "BOOL", "INT"]))

print(bytePadding(["BOOL", "SHORT", "BOOL", "BOOL", "LONG", "SHORT", "SHORT", "FLOAT"]))
print(bytePadding(["BOOL", "BOOL", "BOOL", "FLOAT", "LONG", "SHORT", "SHORT", "FLOAT"]))
print(bytePadding(["BOOL", "BOOL", "FLOAT", "BOOL", "LONG", "SHORT", "SHORT", "FLOAT"]))

print(bytePadding(["BOOl", "LONG", "SHORT", "LONG", "BOOL", "LONG", "BOOL", "LONG", "SHORT", "LONG", "LONG"]))

/*
 ########,########,#.##....,########,########
 ########,##..####,########,#.......
 ########,#.......,########
 #.####..,########,########,########
 ###.####,########,########,########
 ##..####,#.......,########,########,########
 HALT
 */
