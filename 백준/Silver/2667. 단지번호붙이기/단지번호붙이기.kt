private val bw = System.`out`.bufferedWriter()
val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val board = Array(N) { IntArray(N) }
    val visited = Array(N) { BooleanArray(N) }
    val buildings = ArrayList<Int>()

    repeat(N) { x ->
        val str = readLine()
        repeat(N) { y ->
            board[x][y] = str[y]- '0'
        }
    }

    fun bfs(x: Int, y: Int): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()
        var count = 0
        queue.addLast(x to y)
        visited[x][y] = true
        count++

        while (!queue.isEmpty()) {
            val current = queue.removeFirst()
            val cx = current.first
            val cy = current.second
            for (i in 0..3) {
                val nx = cx + dx[i]
                val ny = cy + dy[i]
                if (nx >= N || nx < 0 || ny >= N || ny < 0) continue
                if (board[nx][ny] == 0 || visited[nx][ny]) continue
                if (visited[nx][ny]) continue

                queue.add(nx to ny)
                visited[nx][ny] = true
                count++
            }
        }

        return count
    }

    for (x in 0 until N) {
        for (y in 0 until N) {
            if (board[x][y] == 1 && !visited[x][y]) {
                buildings.add(bfs(x, y))
            }
        }
    }

    buildings.sort()

    bw.append("${buildings.size} \n")
    for ( num in buildings){
        bw.append("$num \n")
    }

    bw.flush()
}