import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val sumArr = Array(n + 1) { IntArray(n + 1) }

    repeat(n) { i ->
        st = StringTokenizer(br.readLine())
        repeat(n) { j ->
            val now = st.nextToken().toInt()
            sumArr[i + 1][j + 1] = sumArr[i + 1][j] + sumArr[i][j + 1] - sumArr[i][j] + now
        }
    }

    val sb = StringBuilder()
    repeat(m) {
        st = StringTokenizer(br.readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        
        val r = sumArr[x2][y2] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2] + sumArr[x1 - 1][y1 - 1]
        sb.appendLine(r)
    }
    println(sb)
}