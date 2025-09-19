import kotlin.math.max

private fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val weights = IntArray(n)
    val values = IntArray(n)

    // 굳이 n+1 크기로 만들 필요 없이 0-indexed로 처리
    repeat(n) { i ->
        val (w, v) = readLine().split(" ").map { it.toInt() }
        weights[i] = w
        values[i] = v
    }

    // O(K) 공간만 사용하는 1차원 dp 배열
    val dp = IntArray(k + 1)

    for (i in 0 until n) {
        val w = weights[i]
        val v = values[i]

        // 🚨 안쪽 반복문을 k부터 w까지 거꾸로 순회
        for (j in k downTo w) {
            // 현재 물건을 넣는 경우 vs 넣지 않는 경우
            dp[j] = max(dp[j], v + dp[j - w])
        }
    }

    println(dp[k])
}