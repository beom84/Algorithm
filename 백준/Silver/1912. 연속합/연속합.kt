import kotlin.math.max

fun main() {
    val n = readln().toInt()
    var sum = 0
    var sumMax = 0
    var max = -1000
    readln().split(" ").map {
        val num = it.toInt()
        max = max(max, num)
        sum = if (sum + num < 0) 0 else sum + num
        sumMax = max(sum,sumMax)
    }
    print(if(max<0) max else max(max,sumMax))
}