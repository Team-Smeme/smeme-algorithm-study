package 구현

fun main() {
    val n = readln().toInt()

    val arr = Array(n) { 0 }
    val load = readln().split(" ")

    for (i in 0 until n) {
        arr[i] = load[i].toInt()
    }

    var sum = 0
    var result = 0

    for (i in 0 until n - 1) {
        if (arr[i] < arr[i + 1]) sum += (arr[i + 1] - arr[i])
        else sum = 0
        result = Math.max(result, sum)
    }
    println(result)
}