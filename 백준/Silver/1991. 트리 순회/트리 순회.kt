private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()

    //ArrayList로 넣는데 오른쪽 왼쪽을 구분해야해. 그냥 인덱스로 구분하고 char로처리하자
    val tree = Array(N) { IntArray(2) }
    repeat(N) { i ->
        val line = readLine().split(" ")
        val node = line[0][0] - 'A'
        val left = if (line[1][0] != '.') line[1][0] - 'A' else -1
        val right = if (line[2][0] != '.') line[2][0] - 'A' else -1

        tree[node][0] = left
        tree[node][1] = right
    }

    fun preOrder(node: Int) { // 출력하고 다음거부르기
        val currentNode = ('A' +node).toString()
        bw.append(currentNode)
        if (tree[node][0] != -1)
            preOrder(tree[node][0])
        if (tree[node][1] != -1)
            preOrder(tree[node][1])
    }
    fun inOrder(node: Int) { // 출력하고 다음거부르기
        val currentNode = ('A' +node).toString()

        if (tree[node][0] != -1)
            inOrder(tree[node][0])
        bw.append(currentNode)
        if (tree[node][1] != -1)
            inOrder(tree[node][1])
    }
    fun postOrder(node: Int) { // 출력하고 다음거부르기
        val currentNode = ('A' +node).toString()

        if (tree[node][0] != -1)
            postOrder(tree[node][0])
        if (tree[node][1] != -1)
            postOrder(tree[node][1])
        bw.append(currentNode)
    }

    preOrder(0)
    bw.append("\n")
    inOrder(0)
    bw.append("\n")
    postOrder(0)
    bw.append("\n")

    bw.flush()
}