import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val dp = Array(N + 1) { IntArray(3) }
    Arrays.fill(dp[1], 1)
    for (i in 2..N) {
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]
        dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
        dp[i][2] = dp[i - 1][0] + dp[i - 1][1]

        dp[i][0] %= 9901
        dp[i][1] %= 9901
        dp[i][2] %= 9901
    }
    println("${(dp[N][0] + dp[N][1] + dp[N][2]) % 9901}")
}