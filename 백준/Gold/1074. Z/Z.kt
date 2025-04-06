import kotlin.math.pow

private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val (N, r, c) = readLine().split(" ").map { it.toInt() }
    bw.write("${recursive(N, r, c)}")
    bw.flush()
    bw.close()
}

fun recursive(n: Int, r: Int, c: Int): Int {
    if (n == 1) {
        return 2 * r + c
    }
    val median = (2.0.pow(n - 1) - 1).toInt()
    var division = 0
    var dr = r
    var dc = c
    when {
        r > median && c > median -> {
            division = 3
            dr -= median + 1
            dc -= median + 1
        }

        r > median && c <= median -> {
            division = 2
            dr -= median + 1
        }

        r <= median && c > median -> {
            division = 1
            dc -= median + 1
        }

        else -> {
            division = 0
        }
    }
    val num = division * (median + 1.0).pow(2).toInt()
    return num + recursive(n - 1, dr, dc)
}