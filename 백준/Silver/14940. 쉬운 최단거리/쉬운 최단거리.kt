import java.util.*
private val bw = System.`out`.bufferedWriter()
private val dX = intArrayOf(0, 1, 0, -1)
private val dY = intArrayOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val visited = Array(n) { BooleanArray(m) }
    val board = Array(n) { IntArray(m) }
    val dist = Array(n) { IntArray(m){-1} } // 정답지
    var start = 0

    repeat(n) { col ->
        val line = StringTokenizer(readLine())
        repeat(m) { row ->
            board[col][row] = line.nextToken().toInt()
            if (board[col][row] == 2) start = col * 2000 + row
            else if(board[col][row] == 0) dist[col][row] = 0
        }
    }

    fun bfs(loc: Int) {
        val q = ArrayDeque<Int>() // x는 최대 1000이니까 x *2000 y/2000

        q.addLast(start)
        visited[start / 2000][start % 2000] = true
        dist[start/2000][start%2000] = 0

        while (q.isNotEmpty()) {
            val current = q.removeFirst()
            val cx = current / 2000
            val cy = current % 2000
            val cDist = dist[cx][cy]

            for (i in 0..3) {
                val nx = cx + dX[i]
                val ny = cy + dY[i]

                if (nx !in 0 until n || ny !in 0 until m) continue
                if (visited[nx][ny]) continue
                if (board[nx][ny] == 0) { // 0이면 놔두기
                    visited[nx][ny] = true
                    continue
                }

                q.addLast(nx * 2000 + ny)
                visited[nx][ny] = true
                dist[nx][ny] = cDist + 1
            }
        }
        // start 기주능로 퍼져나간다. 0 이면 멈추기 방문해도 멈추기
    }

    bfs(start)

    for(col in 0 until n){
        for(row in 0 until m){
            bw.append("${dist[col][row]}")
            if(row != m-1) bw.append(" ") else bw.append("\n")
        }
    }

    bw.flush()
    bw.close()
}