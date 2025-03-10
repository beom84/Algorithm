fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val table = Array(n + 1) { IntArray(n + 1) }
    val sumTable = Array(n + 1) { IntArray(n + 1) }
    val sb = StringBuilder()

    for (i in 1..table.lastIndex) {
        val row = readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            table[i][j] = row[j - 1]
        }
    }

    for (i in 1..table.lastIndex) {
        for (j in 1..table.lastIndex) {
            sumTable[i][j] = sumTable[i - 1][j] + sumTable[i][j - 1] - sumTable[i - 1][j - 1] + table[i][j]
        }
    }
    repeat(m) {
//        val location = readLine().split(" ").map { it.toInt() }
//        val a = Pair(location[0], location[1])
//        val b = Pair(location[2], location[3])
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        val sum =
            sumTable[x2][y2] - sumTable[x2][y1 - 1] - sumTable[x1- 1][y2] + sumTable[x1 - 1][y1 - 1]

        sb.append(sum).append("\n")
    }
    println(sb)
}