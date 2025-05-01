import java.util.*
import kotlin.math.min

private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(n + 1) { IntArray(3) } // 1 : DP 값 2: 이전에 선택한 값 3: 중복여부
    val st = StringTokenizer(readLine())
    repeat(3) { idx ->
        dp[1][idx] = st.nextToken().toInt()
    }
    for (i in 2..n) {
        val rgb = StringTokenizer(readLine())
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb.nextToken().toInt()
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb.nextToken().toInt()
        dp[i][2] = min(dp[i - 1][1], dp[i - 1][0]) + rgb.nextToken().toInt()
    }
    bw.append("${min(dp[n][0],min(dp[n][1],dp[n][2]))}")
    bw.flush()
    close()
}