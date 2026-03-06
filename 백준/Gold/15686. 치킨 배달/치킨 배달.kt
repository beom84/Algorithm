import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val board = Array(N) { IntArray(N) }
    val chickenHouse = ArrayList<Int>()
    val house = ArrayList<Int>()

    repeat(N) { x ->
        val st = StringTokenizer(readLine())
        repeat(N) { y ->
            val num = st.nextToken().toInt()
            board[x][y] = num
            if (num == 1) house.add(1000 * x + y)
            else if (num == 2) chickenHouse.add(1000 * x + y)
        }
    }

    val visited = BooleanArray(chickenHouse.size)
    val selected = IntArray(M)
    var minDist = Int.MAX_VALUE


    fun backTracking(depth: Int, idx: Int) {
        if (depth == M) {
            var sum = 0
            for (loc in house) {
                var min = Int.MAX_VALUE
                val hx = loc / 1000
                val hy = loc % 1000

                for (chicken in selected) { //집에서 가장가까운 치킨집과의 거리
                    val cx = chicken / 1000
                    val cy = chicken % 1000
                    val distance = Math.abs(cx - hx) + Math.abs(cy - hy)

                    min = Math.min(distance, min)
                }
                sum += min // 각 집에대한 최소를 구하고 sum 찾기
            }
            minDist = Math.min(minDist, sum)
            return
        }

        for (i in idx..chickenHouse.lastIndex) {
            if (!visited[i]) {
                selected[depth] = chickenHouse[i]
                visited[i] = true
                backTracking(depth + 1, i + 1)
                visited[i] = false
            }
        }
    }

    backTracking(0, 0)

    println(minDist)
}
