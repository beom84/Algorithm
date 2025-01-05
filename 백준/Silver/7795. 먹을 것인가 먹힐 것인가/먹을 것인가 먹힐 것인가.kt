fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (N, M) = readLine().split(" ").map { it.toInt() }
        val aType = readLine().split(" ").map { it.toInt() }
        var bType = readLine().split(" ").map { it.toInt() }
        var answer = 0
        bType = bType.sortedDescending()
        aType.forEach { A ->
            for (i in bType.indices) {
                if (A > bType[i]) {
                    answer += bType.size - i
                    break
                }
            }
        }
        println(answer)
    }
}