import kotlin.math.max

private fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val weights = IntArray(n+1)
    val values = IntArray(n+1)

    repeat(n) { i ->
        val line = readLine().split(" ").map { it.toInt() }
        weights[i+1] = line[0]
        values[i+1] = line[1]
    }

    val dp = Array(n+1) { IntArray(k+1) }

    for (i in 1 .. n) {
        val w = weights[i]
        val v = values[i]

        for (j in 1 .. k)
            if (w > j) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = max(dp[i - 1][j], v + dp[i - 1][j - w])
            }
    }

    println(dp[n][k])
}