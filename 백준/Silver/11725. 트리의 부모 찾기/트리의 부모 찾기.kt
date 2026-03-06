private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    // N 받고 간선 저장
    val N = readLine().toInt()
    val graph = Array(N + 1) { ArrayList<Int>() } // 0 제외
    val visited = BooleanArray(N + 1) // 0 제외
    val parentNode = IntArray(N + 1)

    //graph 저장
    repeat(N - 1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    fun bfs() {
        val queue = ArrayDeque<Int>()
        queue.addLast(1)
        visited[1] = true
        //1은 저장하지 않는다
        while (!queue.isEmpty()) {
            val parent = queue.removeFirst()
            // 방문하지 않은 아래 노드들은 모두 나의 자식이다.
            for (child in graph[parent]) {
                if (visited[child]) continue

                queue.addLast(child)
                visited[child] = true
                parentNode[child] = parent
            }
        }
    }

    // 맨 아래 노드를 보고 자신의 부모를 저장한다.
    fun dfs(node: Int) {
        for (child in graph[node]) {
            if (!visited[child]) {
                parentNode[child] = node
                visited[child] = true
                dfs(child) // 자식을 호출한다.
            }
        }
        // 부모가 자식을 확인할까?
    }
    visited[1] = true
    dfs(1)
    for (i in 2..parentNode.lastIndex) {
        val parent = parentNode[i]

        bw.append("$parent\n")
    }

    bw.flush()
}