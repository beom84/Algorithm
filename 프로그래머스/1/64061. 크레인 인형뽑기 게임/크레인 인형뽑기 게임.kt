import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var count = 0
        val characterBoard = Array(board[0].size) { Stack<Int>() }
        val bucket = Stack<Int>()

        for (i in board[0].lastIndex downTo 0) {
            for (j in board.indices) {
                if (board[i][j] != 0) {
                    characterBoard[j].push(board[i][j])
                }
            }
        }

        moves.forEach { index ->
            val character = if (characterBoard[index - 1].isNotEmpty())
                characterBoard[index - 1].pop() else return@forEach
            if (bucket.isEmpty()) {
                bucket.push(character)
            } else {
                if (bucket.last() == character) {
                    count += 2
                    bucket.pop()
                } else {
                    bucket.push(character)
                }
            }
        }
        return count
    }
}

