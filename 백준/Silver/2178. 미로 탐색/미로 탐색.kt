import java.util.*

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val board = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) }
    val queue = ArrayDeque<MinLocation>()

    repeat(n) { x ->
        val str = readLine().chunked(1)
        repeat(m) { y ->
            board[x][y] = str[y].toInt()

        }
    }

    queue.add(MinLocation(0, 0, 1))
    visited[0][0] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        if(current.x == n-1 && current.y == m-1){
            println(current.count)
            return
        }

        for (i in 0..3) {
            val nx = current.x + dx[i]
            val ny = current.y + dy[i]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if (board[nx][ny] == 0 || visited[nx][ny]) continue

            queue.offer(MinLocation(nx, ny, current.count + 1))
            visited[nx][ny] = true
        }
    }

}

data class MinLocation(val x: Int, val y: Int, val count: Int)

