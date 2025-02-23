fun main() = with(System.`in`.bufferedReader()) {
    val pipeLayout = readLine()
    var pipeCount = 0
    var sum = 0

    for (i in pipeLayout.indices) {
        when (pipeLayout[i]) {
            '(' -> {
                if (pipeLayout[i + 1] != ')')
                    pipeCount++
                else {
                    sum += pipeCount
                }

            }

            ')' -> {
                if (pipeLayout[i - 1] != '(') {
                    pipeCount--
                    sum++
                }
            }
        }
    }
    println(sum)
}