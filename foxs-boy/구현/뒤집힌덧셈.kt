package 구현

fun main() {
    val list = readln().split(" ")
    val X = Rev(list[0].toInt())
    val Y = Rev(list[1].toInt())
    val res = Rev(X + Y)
    println(res)
}


private fun Rev(N: Int): Int {
    var N = N
    var str = ""
    while (N > 0) {
        str += N % 10
        N /= 10
    }
    return str.toInt()
}
