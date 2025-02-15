fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val queue = ArrayList<Int>()
    val sb = StringBuilder()

    repeat(n) {
        val command = readLine().split(" ")
        when (command[0]) {
            "push" -> queue.add(command[1].toInt())
            "pop" -> sb.append(if (queue.isEmpty()) -1 else queue.removeFirst()).append("\n")
            "size" -> sb.append(queue.size).append("\n")
            "empty" -> sb.append(if (queue.isEmpty()) 1 else 0).append("\n")
            "front" -> sb.append(if (queue.isEmpty()) -1 else queue.first()).append("\n")
            "back" -> sb.append(if (queue.isEmpty()) -1 else queue.last()).append("\n")
        }
    }

    println(sb)
}