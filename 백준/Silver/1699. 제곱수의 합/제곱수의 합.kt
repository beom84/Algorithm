import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val dp = Array(N + 1) { it }

    for (i in 1..N) {
        var j = 1
        while (j * j <= i) {
            dp[i] = min(dp[i], dp[i - j * j] + 1)
            j++
        }
    }
    
    println(dp[N])
}