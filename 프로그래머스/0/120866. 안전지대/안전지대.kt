class Solution {
    fun solution(board: Array<IntArray>): Int {
        val n = board.size
        var count = 0
        val wideBoard = Array(n + 2) { IntArray(n + 2) { 0 } }
        for (i in board.indices) {
            for (j in board.indices) {
                if (board[i][j] == 1) {
                    val x = i + 1
                    val y = j + 1
                    wideBoard[x][y] = 1
                    wideBoard[x - 1][y] = 1
                    wideBoard[x + 1][y] = 1
                    wideBoard[x][y - 1] = 1
                    wideBoard[x][y + 1] = 1
                    wideBoard[x - 1][y + 1] = 1
                    wideBoard[x - 1][y - 1] = 1
                    wideBoard[x + 1][y - 1] = 1
                    wideBoard[x + 1][y + 1] = 1
                }
            }
        }

        for (i in board.indices) {
            for (j in board.indices) {
                if (wideBoard[i + 1][j + 1] == 0) count++
            }
        }
        return count
    }
}