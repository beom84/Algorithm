private fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val schedules = Array(n) { IntArray(2) }
    repeat(n) { index ->
        val st = readLine().split(" ").map { it.toInt() }
        schedules[index][0] = st[0]
        schedules[index][1] = st[1]
    }

    schedules.sortWith(compareBy({ it[1] }, { it[0] }))
    var count = 0
    var end = 0
    for (i in schedules.indices) {
        val startTime = schedules[i][0]
        val endTime = schedules[i][1]
        if (end <= startTime) {
            end = endTime
            count++
        }
        else continue
    }

    println(count)
}