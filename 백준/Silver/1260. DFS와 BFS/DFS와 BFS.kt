
import java.util.StringTokenizer

private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val line = readLine().split(" ").map { it.toInt() }
    val N = line[0] // 정점의 개수
    val M = line[1] // 간선의 개수
    val V = line[2] // 시작 정점

    val graph = Array(N + 1) { ArrayList<Int>() } // 1부터 시작

    repeat(M) {
        val line = StringTokenizer(readLine())
        val start = line.nextToken().toInt()
        val end = line.nextToken().toInt()
        graph[start].add(end)
        graph[end].add(start)
    }

    for (i in 1..N) {
        graph[i].sort()
    }

    val dfsVisited = BooleanArray(N + 1)
    dfsVisited[V] = true

    fun dfs(depth: Int, node: Int) {
        if (depth == N + 1) {
            return
        }
        bw.append("$node ")

        for (nextNode in graph[node]) {
            if (!dfsVisited[nextNode]) {
                dfsVisited[nextNode] = true

                dfs(depth + 1, nextNode)
            }
        }
    }

    fun bfs() {
        val queue = ArrayDeque<Int>()
        val visited = BooleanArray(N + 1)
        queue.addLast(V)
        visited[V] = true

        while (!queue.isEmpty()) {
            val currentNode = queue.removeFirst()
            bw.append("$currentNode ")

            for (nextNode in graph[currentNode]) {
                if (visited[nextNode]) continue
                queue.addLast(nextNode)
                visited[nextNode] = true
            }
        }
    }
    dfs(1, V)

    bw.append("\n")

    bfs()

    bw.flush()
}