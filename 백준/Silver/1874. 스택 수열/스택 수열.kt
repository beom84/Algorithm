fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    var index = 1
    val stack = ArrayList<Int>()
    repeat(n) {
        val num = readLine().toInt()
        if (stack.contains(num)) {
            if (stack.removeLast() == num) sb.append("-").append("\n")
            else {
                println("NO")
                return@with
            }
        } else {
            while (index <= num) {
                sb.append("+").append("\n")
                stack.add(index++)
            }
            stack.removeLast()
            sb.append("-").append("\n")
        }
    }
    println(sb)
}