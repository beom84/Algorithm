import java.util.ArrayDeque

// MyLocation 클래스는 동일
private class MyLocation(val x: Int, val y: Int, val count: Int, val wallBroken: Int) // isBreaking을 Int로 변경 (0: 안부숨, 1: 부숨)

private var n: Int = 0
private var m: Int = 0
private lateinit var boards: Array<IntArray>
// visited를 3차원 배열로 변경
private lateinit var visited: Array<Array<BooleanArray>>
private val dx = listOf(0, 1, 0, -1)
private val dy = listOf(1, 0, -1, 0)

private fun main() = with(System.`in`.bufferedReader()) {
    val line = readLine().split(" ").map { it.toInt() }
    n = line[0]
    m = line[1]
    boards = Array(n) { IntArray(m) }
    // visited[wallBroken_status][x][y]
    visited = Array(2) { Array(n) { BooleanArray(m) } }

    repeat(n) { i ->
        boards[i] = readLine().chunked(1).map { it.toInt() }.toIntArray()
    }

    val queue = ArrayDeque<MyLocation>()
    // 시작점: (0,0), 거리 1, 벽 안부숨(0)
    queue.addLast(MyLocation(0, 0, 1, 0))
    visited[0][0][0] = true // 벽 안부순 상태로 (0,0) 방문

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        val cx = current.x
        val cy = current.y
        val count = current.count
        val wallBroken = current.wallBroken

        if (cx == n - 1 && cy == m - 1) {
            println(count)
            return
        }

        for (i in 0..3) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue

            // 다음 칸이 벽(1)인 경우
            if (boards[nx][ny] == 1) {
                // 아직 벽을 부순 적이 없고, 벽을 부수고 방문할 곳이 미방문 상태라면
                if (wallBroken == 0 && !visited[1][nx][ny]) {
                    visited[1][nx][ny] = true
                    queue.addLast(MyLocation(nx, ny, count + 1, 1))
                }
            }
            // 다음 칸이 길(0)인 경우
            else {
                // 현재 상태(wallBroken) 그대로 다음 칸이 미방문 상태라면
                if (!visited[wallBroken][nx][ny]) {
                    visited[wallBroken][nx][ny] = true
                    queue.addLast(MyLocation(nx, ny, count + 1, wallBroken))
                }
            }
        }
    }
    println(-1)
}