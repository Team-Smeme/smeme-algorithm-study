package 구현

fun main() {
    val word = readln()
    var sum = 0
    for (element in word) {
        sum += 1 + when (element) {
            'A', 'B', 'C' -> 2
            'D', 'E', 'F' -> 3
            'G', 'H', 'I' -> 4
            'J', 'K', 'L' -> 5
            'M', 'N', 'O' -> 6
            'P', 'Q', 'R', 'S' -> 7
            'T', 'U', 'V' -> 8
            'W', 'X', 'Y', 'Z' -> 9
            else -> 0
        }
    }
    print(sum)
}