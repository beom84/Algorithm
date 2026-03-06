private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(M)
    val visited = BooleanArray(N + 1)

    fun backTracking(depth: Int, idx: Int) {
        if (depth == M) {
            for (num in arr) {
                bw.append("$num ")
            }
            bw.append("\n")

            return
        }

        for (num in idx..N) {
            arr[depth] = num
            backTracking(depth + 1, num + 1)
        }
    }
    backTracking(0, 1)
    bw.flush()
}