import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stairs = Array(n + 1) { 0 }
    repeat(n) { idx ->
        stairs[idx + 1] = readLine().toInt()
    }

    val dp = Array(n + 1) { 0 }

    if (n == 1) {
        println(stairs[1])
        return
    }

    dp[1] = stairs[1]
    dp[2] = stairs[1] + stairs[2]

    for (i in 3..n) {
        dp[i] = max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i])
    }

    println(dp[n])
}