import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    while (true) {
        val n = readLine().toInt()
        if (n == 0) break

        val words = mutableListOf<String>()
        repeat(n) {
            words.add(readLine())
        }

        val firstWord = words.minByOrNull { it.lowercase() }
        
        sb.append(firstWord).append("\n")
    }
    print(sb)
}