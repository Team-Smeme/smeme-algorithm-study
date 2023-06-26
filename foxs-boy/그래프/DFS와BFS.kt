package 그래프

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var arr = Array(0) { Array(0) { 0 } }
private var visit = Array(0) { false }
private var sb = StringBuilder();

private var N: Int = 0;
private var M: Int = 0;
private var count: Int = 0;

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    var V = st.nextToken().toInt()
    arr = Array(N + 1) { Array((N + 1)) { 0 } }
    visit = Array(N + 1) { false }

    for (i in 1..M step 1) {
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        arr[x][y] = 1
        arr[y][x] = 1
    }

    DFS(V)
    sb.append('\n')

    visit = Array(N + 1) { false }
    BFS(V)

    print(sb)

}

fun DFS(nodeNum: Int) {
    visit[nodeNum] = true;
    sb.append("$nodeNum ")

    if (count == N) return
    count++
    for (i in 1..N step 1) {
        if (arr[nodeNum][i] == 1 && !visit[i]) DFS(i)
    }
}

fun BFS(nodeNum: Int) {
    var queue: Queue<Int> = LinkedList<Int>()
    queue.offer(nodeNum)
    visit[nodeNum] = true
    sb.append("$nodeNum ")

    while (!queue.isEmpty()) {

        var nodeNum = queue.poll()

        for (i in 1..N step 1) {
            if (arr[nodeNum][i] == 1 && !visit[i]) {
                queue.offer(i)
                visit[i] = true
                sb.append("$i ")
            }
        }
    }
    queue.clear()

}