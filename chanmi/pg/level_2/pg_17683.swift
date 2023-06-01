//
//  pg_17683.swift
//  smeme-algorithm
//
//  Created by 황찬미 on 2023/06/01.
//
//  [3차] 방금그곡 - 2018 KAKAO BLIND RECRUITMENT
//  https://school.programmers.co.kr/learn/courses/30/lessons/17683

import Foundation

func solution(_ m:String, _ musicinfos:[String]) -> String {
    var resultArray = [(time: Int, musicName: String)]()
    
    func replaceStr(_ string: String) -> String {
        return string.replacingOccurrences(of: "C#", with: "c")
                     .replacingOccurrences(of: "D#", with: "d")
                     .replacingOccurrences(of: "F#", with: "f")
                     .replacingOccurrences(of: "G#", with: "g")
                     .replacingOccurrences(of: "A#", with: "a")
    }
    
    func checkMusic(_ checkString: String, _ totalMusic: String) -> Bool {
        if totalMusic.contains(checkString) {
            return true
        }
        return false
    }
    
    let m = replaceStr(m)
    
    for music in musicinfos {
        let splitStr = music.split(separator: ",").map{String($0)}
        
        let startTime = splitStr[0]
        let endTime = splitStr[1]
        let musicName = splitStr[2]
        let musicPlaying = splitStr[3]
        
        let splitStartTime = startTime.split(separator: ":").map{Int(String($0))!}
        let splitEndTime = endTime.split(separator: ":").map{Int(String($0))!}
        
        let replayMusicCount = (splitEndTime[0]-splitStartTime[0]) * 60 + splitEndTime[1]-splitStartTime[1]
        
        var changeMusicPlaying = replaceStr(musicPlaying)
        var tempString = ""
        
        for i in 0..<replayMusicCount {
            let index = i % changeMusicPlaying.count
            tempString += String(changeMusicPlaying[changeMusicPlaying.index(musicPlaying.startIndex, offsetBy: index)])
        }
        
        if checkMusic(m, tempString) {
            resultArray.append((time: replayMusicCount, musicName: musicName))
        }
        
    }
    
    let sorted = resultArray.enumerated().sorted {
        if $0.element.time == $1.element.time {
            return $0.offset < $1.offset
        }
        return $0.element.time > $1.element.time
    }
    
    return sorted.first?.element.musicName ?? "(None)"
}

print(solution("CC#BCC#BCC#BCC#B", ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]))
