fun main() = with(System.`in`.bufferedReader()) {
    val stack = ArrayList<Char>()
    val sb = StringBuilder()
    val n = readLine().toInt()
    repeat(n) {
        val str = readLine()
        for (i in str.indices) {
            when (val ps = str[i]) {
                '(' -> {
                    stack.add(ps)
                }

                else -> {
                    if (stack.isEmpty()) {
                        stack.add(ps)
                        break
                    } else {
                        stack.removeLast()
                    }
                }
            }
        }
        sb.append(if (stack.isNotEmpty()) "NO" else "YES").append("\n")
        stack.clear()
    }

    println(sb)
}