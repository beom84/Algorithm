private val bw = System.`out`.bufferedWriter()
private var left = ArrayDeque<Char>()
private var right = ArrayDeque<Char>()

private fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val str = readLine()
        str.forEach { c -> handleEditor(c) }
        left.forEach{c -> bw.append(c)}
        right.forEach{c -> bw.append(c)}
        bw.append("\n")

        left.clear()
        right.clear()
    }
    bw.flush()
}

private fun handleEditor(key: Char) {
    when (key) {
        '<' -> {
            if (left.isNotEmpty()) {
                right.addFirst(left.removeLast())
            }
        }

        '>' -> {
            if (right.isNotEmpty()) {
                left.addLast(right.removeFirst())
            }
        }

        '-' -> {
            if (left.isNotEmpty()) {
                left.removeLast()
            }
        }

        else -> {
            left.addLast(key)
        }
    }
}