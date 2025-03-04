package baekjoon_practice

lateinit var numbers: IntArray
lateinit var visited: Array<Boolean>

var totalNum = 0
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
        totalNum = numbers[0] // 첫 번째 원소는 개수 정보

        if (totalNum == 0) break

        visited = Array(totalNum) { false } // ✅ 불필요한 +1 제거
        printNumber(0, 0)
        sb.append("\n")
    }

    print(sb)
}

fun printNumber(number: Int, count: Int) {
    if (count == 6) {
        for (i in 0 until totalNum) {
            if (visited[i]) {
                sb.append(numbers[i + 1]).append(" ") // ✅ numbers[1]부터 숫자가 시작함
            }
        }
        sb.append("\n")
        return
    }

    for (i in number until totalNum) { // ✅ 범위 수정
        visited[i] = true
        printNumber(i + 1, count + 1)
        visited[i] = false
    }
}