private val bw = System.`out`.bufferedWriter()
private lateinit var dp :IntArray

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    dp = IntArray(12)
    dp[1] =1
    dp[2] = 2
    dp[3] = 4
    for(i in 4..11){
        dp[i] =dp[i-1]+dp[i-2]+dp[i-3]
    }
    repeat(n){
        bw.append("${dp[readLine().toInt()]}\n")
    }

    bw.flush()
    close()
}