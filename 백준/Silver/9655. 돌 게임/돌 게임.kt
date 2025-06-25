fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(1001) { false }
    dp[1] = true
    dp[2] = false
    dp[3] = true
    for (i in 1..n - 3) {
        dp[i + 1] = !dp[i]
        dp[i + 3] = !dp[i]
    }
    println(if (dp[n]) "SK" else "CY")
}