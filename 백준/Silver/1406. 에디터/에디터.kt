fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val mainList = str.map { it }.toMutableList()
    val subList = mutableListOf<Char>()
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val command = readLine().split(" ")
        when (command[0]) {
            "L" -> {
                if (mainList.size != 0) {
                    val subLastIndex = subList.size
                    subList.add(subLastIndex, mainList.removeLast())
                }
            }

            "D" -> {
                if (subList.size != 0) {
                    val mainLastIndex = mainList.size
                    mainList.add(mainLastIndex, subList.removeLast())
                }
            }

            "B" -> {
                if (mainList.size != 0)
                    mainList.removeLast()
            }

            "P" -> {
                val mainLastIndex = mainList.size
                mainList.add(mainLastIndex, command[1][0])
            }
        }
    }

    for (i in mainList) sb.append(i)
    for (i in subList.lastIndex downTo 0) sb.append(subList[i])

    println(sb)
}