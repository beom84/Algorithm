import java.util.*
import kotlin.math.max


fun main(args: Array<String>) {
    val n = readln().toInt()
    val heightBoard = Array(n) { IntArray(n) }
    var max = 1

    repeat(n) { index ->
        val heightColumn = readln().split(" ").map { it.toInt() }.toIntArray()
        max = max(heightColumn.max(), max)
        heightBoard[index] = heightColumn
    }
    var maxCount = 1

    for (rainAmount in 1 .. max) {
        var count = 0
        val visited = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (heightBoard[i][j] > rainAmount && !visited[i][j]) {
                    bfs(n, Pair(i, j), visited, heightBoard, rainAmount)
                    count++
                }
            }
        }
        maxCount = max(maxCount, count)
    }
    print(maxCount)
}


val dirXY = arrayOf(arrayOf(0,1), arrayOf(1,0), arrayOf(0,-1), arrayOf(-1,0))

fun bfs(
    n: Int,
    node: Pair<Int, Int>,
    visited: Array<BooleanArray>,
    heightBoard: Array<IntArray>,
    rainAmount: Int,
) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(node)
    visited[node.first][node.second] = true


    while (queue.isNotEmpty()) {
        val head = queue.poll()

        val y = head.first
        val x = head.second

        for (i in 0 until 4) {
            val ny = y + dirXY[i][0]
            val nx = x + dirXY[i][1]

            if (ny !in 0 until n || nx !in 0 until n || visited[ny][nx] || heightBoard[ny][nx] <= rainAmount) continue
            queue.add(Pair(ny, nx))
            visited[ny][nx] = true
        }
    }
}