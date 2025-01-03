import kotlin.math.ceil

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readln().split(" ").map(String::toInt)
    val J = List(M) { readLine().toInt() }
    var (l, r) = 1L to J.maxOf { it }.toLong()
    var answer = r

    while (l <= r) {
        val m = (l + r).div(2)
        var cnt = 0
        for (j in J) {
            cnt += ceil(j.toDouble().div(m)).toInt()
        }
        if (cnt <= N) {
            r = m - 1
            answer = m
        } else {
            l = m + 1
        }
    }
    print(answer)
}