fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    var index = 1
    val stack = ArrayList<Int>()
    repeat(n) {
        val num = readLine().toInt()
        if (stack.isNotEmpty() && stack.last() == num) {
            stack.removeLast()
            sb.append("-").append("\n")
        } else {
            while (index <= num) {
                sb.append("+").append("\n")
                stack.add(index++)
            }
            if (stack.removeLast() != num) {
                println("NO")
                return@with
            }
            sb.append("-").append("\n")
        }
    }
    println(sb)
}