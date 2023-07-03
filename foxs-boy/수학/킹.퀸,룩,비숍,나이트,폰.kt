fun main() {

    println(readLine()?.split(" ")?.mapIndexed { index, ea -> movementCheck(index, ea.toInt()) }?.joinToString(" "))

}

fun movementCheck(index: Int, movementEA: Int): Int {
    return when (index) {
        0 -> 1 - movementEA
        1 -> 1 - movementEA
        2 -> 2 - movementEA
        3 -> 2 - movementEA
        4 -> 2 - movementEA
        else -> 8 - movementEA
    }
}