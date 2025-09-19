import kotlin.math.max

private fun main() = with(System.`in`.bufferedReader()){
    val n  = readLine().toInt()
    val ropes = IntArray(n)

    for (i in 0 until n) {
        ropes[i] = readLine().toInt()
    }

    ropes.sort()


    var max = 0
    var count = n

    for(i in ropes.indices){
        max = max(max,ropes[i]*count--)
    }

    println(max)
}