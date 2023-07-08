package 구현

fun main() {
    val s = readln()
    val arr = IntArray(10)
    for (element in s) {
        val num = Character.getNumericValue(element)
        if (num == 6) {
            arr[9]++
        } else {
            arr[num]++
        }
    }
    var max = 0
    for (i in 0..8) {
        max = max.coerceAtLeast(arr[i])
    }
    var nine = arr[9] / 2
    if (arr[9] % 2 == 1) nine++
    max = max.coerceAtLeast(nine)
    print(max)
}