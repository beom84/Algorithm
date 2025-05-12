import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0) // 상우하좌
private val dy = intArrayOf(0, 1, 0, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, t) = readLine().split(" ").map { it.toInt() }
    val board = Array(r) { IntArray(c) }
    val airCleaners = mutableListOf<Pair<Int, Int>>() // 공기청정기 위치 저장

    repeat(r) { i ->
        val st = StringTokenizer(readLine())
        repeat(c) { j ->
            board[i][j] = st.nextToken().toInt()
            if (board[i][j] == -1) airCleaners.add(i to j)
        }
    }

    repeat(t) {
        diffuse(board, r, c, airCleaners)
        circulate(board, r, c, airCleaners[0].first, airCleaners[1].first)
    }

    val result = board.sumOf { row -> row.sum() } + 2 // 공기청정기 -1이 두 개 있으므로 +2
    println(result)
}

fun diffuse(board: Array<IntArray>, r: Int, c: Int, airCleaners: List<Pair<Int, Int>>) {
    val temp = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (board[i][j] > 0) {
                val spreadAmount = board[i][j] / 5
                var count = 0
                for (d in 0..3) {
                    val nx = i + dx[d]
                    val ny = j + dy[d]
                    if (nx in 0 until r && ny in 0 until c && board[nx][ny] != -1) {
                        temp[nx][ny] += spreadAmount
                        count++
                    }
                }
                board[i][j] -= spreadAmount * count
            }
        }
    }

    for (i in 0 until r) {
        for (j in 0 until c) {
            board[i][j] += temp[i][j]
        }
    }
}

fun circulate(board: Array<IntArray>, r: Int, c: Int, up: Int, down: Int) {
    // 상단 (반시계)
    for (i in up - 1 downTo 1) board[i][0] = board[i - 1][0]
    for (j in 0 until c - 1) board[0][j] = board[0][j + 1]
    for (i in 0 until up) board[i][c - 1] = board[i + 1][c - 1]
    for (j in c - 1 downTo 2) board[up][j] = board[up][j - 1]
    board[up][1] = 0

    for (i in down + 1 until r - 1) board[i][0] = board[i + 1][0]
    for (j in 0 until c - 1) board[r - 1][j] = board[r - 1][j + 1]
    for (i in r - 1 downTo down + 1) board[i][c - 1] = board[i - 1][c - 1]
    for (j in c - 1 downTo 2) board[down][j] = board[down][j - 1]
    board[down][1] = 0
}