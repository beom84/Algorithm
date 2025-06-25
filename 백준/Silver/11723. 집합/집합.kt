import java.util.*

private val bw = System.`out`.bufferedWriter()
lateinit var set: MutableSet<Int>
val fullSet = Array(20) { idx -> idx + 1 }

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    set = mutableSetOf()

    repeat(n) {
        val str = StringTokenizer(readLine())
        val command = str.nextToken()
        if (command == "all" || command == "empty") {
            controller(command)
        } else {
            val num = str.nextToken().toInt()
            controller(command, num)
        }
    }
    bw.flush()
    bw.close()
}

fun controller(command: String, num: Int) {
    when (command) {
        "add" -> set.add(num)
        "remove" -> set.remove(num)
        "check" -> bw.append(if (set.contains(num)) "1" else "0").append("\n")
        "toggle" -> if (set.contains(num)) set.remove(num) else set.add(num)
    }
}

fun controller(command: String) {
    when (command) {
        "all" -> set = mutableSetOf(*fullSet)
        "empty" -> set.clear()
    }
}