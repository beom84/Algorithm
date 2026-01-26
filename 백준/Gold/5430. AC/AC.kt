private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    repeat(T) {
        var isReversed = false
        var isError = false
        val arr = ArrayDeque<Int>()

        val command = readLine()
        val n = readLine().toInt()
        val str = readLine()

        if (n != 0) {
            str.substring(1, str.lastIndex).split(",").forEach {
                arr.addLast(it.toInt())
            }
        }

        for (c in command) {
            when (c) {
                'R' -> {
                    isReversed = !isReversed
                }

                'D' -> {
                    if (arr.isNotEmpty()) {
                        if (isReversed) {
                            arr.removeLast()
                        } else {
                            arr.removeFirst()
                        }
                    } else {
                        isError = true
                        break
                    }
                }
            }
        }

        if (isError) {
            bw.append("error").append("\n")
        } else {
            val range = if (isReversed) arr.lastIndex downTo 0 else 0..arr.lastIndex
            bw.append("[")
            for (i in range) {
                bw.append("${arr[i]}")
                if (i != range.last) bw.append(",")
            }
            bw.append("]").append("\n")
        }
    }
    bw.flush()
}