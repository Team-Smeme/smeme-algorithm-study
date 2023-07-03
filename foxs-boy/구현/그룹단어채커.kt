package 구현

fun main() {
    val t: Int = readln().toInt()
    var answer = 0

    for (i in 0 until t) {
        var list = ArrayList<Char>()

        var word = readln()
        list.add(word[0])
        var check = true
        for (index in word.indices) {
            if (list[list.size - 1] != word[index]) {
                if (list.contains(word[index])) {
                    check = false
                    break
                } else list.add(word[index])
            }
        }

        if (check) answer++

    }
    println(answer)

}