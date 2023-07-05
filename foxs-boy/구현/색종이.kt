package 구현

fun main() {
    var t: Int = readln().toInt()

    val graph = Array(100) { BooleanArray(100) }
    var answer = 0

    while (t-- > 0) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        for (i in x until x + 10) {
            for (j in y until y + 10) {
                if (graph[i][j]) continue
                graph[i][j] = true
                answer++
            }
        }
    }

    println(answer)
}