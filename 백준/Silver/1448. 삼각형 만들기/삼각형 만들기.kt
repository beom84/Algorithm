fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val sorted = IntArray(N)
    repeat(N) { i ->
        sorted[i] = readLine().toInt()
    }

    sorted.sortDescending()

    var sum = 0
    for (i in 0..sorted.lastIndex - 2) {
        if (sorted[i] < sorted[i + 1] + sorted[i + 2]) {
            sum = sorted[i] + sorted[i + 1] + sorted[i + 2]
            break
        }
    }
    println(if (sum == 0) -1 else sum)
}