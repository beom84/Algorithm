fun main() = with(System.`in`.bufferedReader()) {
    val visited = BooleanArray(200001)
    val queue = ArrayDeque<Pair<Int, Int>>()

    val (n, k) = readLine().split(" ").map { it.toInt() }
    if (n == k) println(0)

    queue.addLast(n to 0)
    visited[n] = true

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()
        val location = cur.first
        val count = cur.second
        for (i in 0..2) {
            val next = operation(location, i)
            if (next < 0 || next > 200000 || visited[next]) continue
            if (next == k) {
                println(count + 1)
                return
            }

            queue.addLast(next to count + 1)
            visited[next] = true
        }
    }

}

fun operation(x: Int, num: Int): Int {
    return when (num) {
        0 -> x + 1
        1 -> x - 1
        else -> x * 2
    }
}