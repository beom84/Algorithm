fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val section = Array(100) { BooleanArray(100) { false } }

    repeat(n) {
        val (p1, p2) = readLine().split(" ").map { it.toInt() }

        for(dx in p1 until p1+10) {
            for(dy in p2 until p2+10) {
                section[dx][dy] = true
            }
        }
    }

    println(section.sumOf {  it.count{it  } })
}