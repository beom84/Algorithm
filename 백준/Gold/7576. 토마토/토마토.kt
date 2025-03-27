fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val tomato = mutableListOf<Pair<Int, Int>>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    var dayCount = 0
    var todayTomatoNum = 0
    var emptySpaceNum = 0
    var totalCount = 0
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)

    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 1) {
                tomato.add(i to j)
                todayTomatoNum++
                totalCount++
            } else if (board[i][j] == -1) {
                emptySpaceNum++
            }
        }
    }

    if (totalCount == n * m) {
        println(0)
        return
    }

    repeat(todayTomatoNum) { idx ->
        queue.add(tomato[idx])
    }

    while (todayTomatoNum != 0) {
        var tomorrowTomatoNum = 0
        repeat(todayTomatoNum) {
            val next = queue.removeFirst()
            for (dir in 0..3) {
                val x = next.first + dx[dir]
                val y = next.second + dy[dir]
                if (x < 0 || x >= n || y < 0 || y >= m) continue
                if (board[x][y] != 0) continue
                board[x][y] = 1
                queue.add(x to y)
                tomorrowTomatoNum++
                totalCount++
            }
        }
        todayTomatoNum = tomorrowTomatoNum
        dayCount++
    }
    println(if (totalCount + emptySpaceNum != n * m) -1 else dayCount - 1)
}