package 구현

fun main() {
    val count = readln().toInt()

    println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.")
    rec(count, 0)
}

fun rec(count: Int, times: Int) {
    if (count == 0) {
        printUnder(times)
        println("\"재귀함수가 뭔가요?\"")
        printUnder(times)
        println("\"재귀함수는 자기 자신을 호출하는 함수라네\"")
        printUnder(times)
        println("라고 답변하였지.")
        return
    }

    printUnder(times)
    println("\"재귀함수가 뭔가요?\"")
    printUnder(times)
    println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.")
    printUnder(times)
    println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.")
    printUnder(times)
    println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"")

    rec(count - 1, times + 1)
    printUnder(times)
    println("라고 답변하였지.")
}

fun printUnder(count: Int) {
    for (count in 0 until count) print("____")
}