package 구현

import java.util.*

fun main() {
    val st = StringTokenizer(readln())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val arr = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        val st = StringTokenizer(readln())
        for (j in 0 until M) arr[i][j] = st.nextToken().toInt()
    }

    val k = readln().toInt()

    repeat(k) {
        val st = StringTokenizer(readln())
        val i = st.nextToken().toInt()
        val j = st.nextToken().toInt()
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        var sum = 0
        for (a in i - 1 until x) {
            for (b in j - 1 until y) sum += arr[a][b]
        }

        println(sum)
    }
}