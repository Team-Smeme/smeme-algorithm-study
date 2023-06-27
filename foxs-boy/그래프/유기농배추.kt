package 그래프

import java.util.*

var m = 0
var n = 0
var k = 0
var cnt = 0

val dx = listOf(-1,1,0,0)
val dy = listOf(0,0,-1,1)

lateinit var map : Array<Array<Int>>

fun main() = with(Scanner(System.`in`)){

    val t = nextInt()

    for(i in 0 until t){
        cnt = 0
        m = nextInt()
        n = nextInt()
        k = nextInt()
        map = Array(m){Array<Int>(n){0} }

        for(j in 0 until k){
            map[nextInt()][nextInt()] = 1
        }

        // 다 방문할때까지 반복
        for(x in 0 until m){
            for(y in 0 until n){
                // 떨어져있는곳 방문할때마다 +1
                if(map[x][y] == 1) {
                    find(x,y)
                    cnt++
                }
            }
        }
        println(cnt)
    }
}

fun find(x : Int, y : Int){
    for(i in 0 until 4){
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx >= 0 && ny >= 0 && nx < m && ny < n){
            if(map[nx][ny] == 1){
                map[nx][ny] = 0
                find(nx,ny)
            }
        }
    }
}