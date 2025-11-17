import java.util.*

private val bw = System.out.bufferedWriter()
private val leftStack = ArrayDeque<Char>()
private val rightStack = ArrayDeque<Char>()

private fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    str.forEach { leftStack.addLast(it) }

    repeat(readLine().toInt()) {
        val commander = readLine()
        val command = commander[0]
        val c = if (command == 'P') commander[2] else null

        handleEditor(command, c)
    }

    leftStack.forEach { bw.write(it.toString()) }
    rightStack.reversed().forEach { bw.write(it.toString()) }

    bw.flush()
}

fun handleEditor(command: Char, c: Char?) {
    when (command) {
        'L' -> {
            if (leftStack.isNotEmpty()) {
                rightStack.addLast(leftStack.removeLast())
            }
        }

        'D' -> {
            if (rightStack.isNotEmpty()) {
                leftStack.addLast(rightStack.removeLast())
            }
        }

        'B' -> {
            if (leftStack.isNotEmpty()) {
                leftStack.removeLast()
            }
        }

        'P' -> {
            leftStack.addLast(c!!)
        }
    }
}