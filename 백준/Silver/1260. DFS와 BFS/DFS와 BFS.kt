import java.util.*

/*
    정점의 개수 N -> 그래프 크기
    간선의 개수 M ->
    시작하는 정점의 번호 V


 */

lateinit var graph: Array<BooleanArray>
lateinit var visited: BooleanArray
var n: Int = 0
var v: Int = 0
private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split(" ").map { it.toInt() }
    n = str[0]
    val m = str[1]
    v = str[2]

    graph = Array(n + 1) { BooleanArray(n + 1) }
    visited = BooleanArray(n + 1)

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a][b] = true
        graph[b][a] = true
    }
    dfs(v)
    visited.fill(false)
    bw.append("\n")
    bfs()
    bw.flush()
}

fun dfs(node: Int) {
    visited[node] = true
    bw.append("$node ")

    for (i in 1..n) {
        if (graph[node][i] && !visited[i]) dfs(i)
    }
}

private fun bfs() {
    val queue = LinkedList<Int>()

    queue.add(v)
    visited[v] = true

    while (!queue.isEmpty()) {
        val node = queue.poll()
        bw.append("$node ")

        for (i in 1..n) {
            if (graph[node][i] && !visited[i]) {
                queue.add(i)
                visited[i] = true
            }
        }
    }
}