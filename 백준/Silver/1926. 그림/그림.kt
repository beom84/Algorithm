import java.util.*
import kotlin.math.max

private lateinit var board: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    board = Array(n + 1) { IntArray(m + 1) }
    visited = Array(n + 1) { BooleanArray(m + 1) }
    var count = 0
    var maxExtent = 0

    repeat(n) { x ->
        val st = StringTokenizer(readLine())
        repeat(m) { y ->
            val painted = st.nextToken().toInt()
            board[x + 1][y + 1] = painted
        }
    }
    // 1인데 방문하지 않았다면 bfs 실행

    repeat(n){ x ->
        repeat(m){y ->
            if(board[x+1][y+1] ==1 && !visited[x+1][y+1]){
                maxExtent = max(bfs(x+1,y+1,n,m),maxExtent)
                count++
            }
        }
    }

    println("$count\n$maxExtent")
}

private fun bfs(x: Int, y: Int, col: Int, row: Int): Int {
    val location = Pair(x, y)
    val queue = ArrayDeque<Pair<Int, Int>>() // 큐니까 offer poll
    var extent = 1

    queue.offer(location)
    visited[x][y] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        val cx = current.first
        val cy = current.second

        for (i in 0..3) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nx <= 0 || nx > col || ny <= 0 || ny > row) continue
            if (board[nx][ny] == 0 || visited[nx][ny]) continue

            queue.offer(nx to ny)
            visited[nx][ny] = true
            extent++
        }
    }
    return extent
}