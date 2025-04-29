import kotlin.math.min

private val bw = System.`out`.bufferedWriter()
private lateinit var dp :IntArray

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    dp = IntArray(n+1)
    dp[1] =0
    for(i in 2 .. n){
        dp[i] = min(dp[i-1]+1,min(if(i%3==0)dp[i/3]+1 else 10000,if(i%2==0)dp[i/2]+1 else 10000))
    }
    bw.write("${dp[n]}")
    bw.flush()
    close()
}