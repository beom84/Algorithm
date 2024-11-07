import kotlin.math.min

fun main(args: Array<String>) {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var coins = IntArray(n)
    val dp = IntArray(k + 1) { 10001 }
    repeat(n) { index ->
        val coin = readln().toInt()
        if (!coins.contains(coin))
            coins[index] = coin
    }

    coins = coins.filter { it != 0 && it <= k }.toIntArray()
    coins.sort()

    dp[0] = 0
    for (i in 1..k) {
        for (coin in coins) {
            if (i - coin >= 0) {
                dp[i] = min(dp[i], dp[i - coin] + 1)
            }
        }
    }
        println(if(dp[k] == 10001) -1 else dp[k])
}
