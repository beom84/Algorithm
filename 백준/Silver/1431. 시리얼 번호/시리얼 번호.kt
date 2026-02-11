import java.util.*

private val bw = System.`out`.bufferedWriter()
private fun String.parsingInt(): Int {
    var sum = 0
    for (c in this) {
        if (c <= '9') {
            val num = c - '0'
            sum += num
        }
    }
    return sum
}

fun main() = with(System.`in`.bufferedReader()) {
    //thenBy로 넘어간다면 파싱후 숫자 로 비교
    val pq = PriorityQueue<String>(compareBy<String>{it.length}.thenBy{it.parsingInt()}.thenBy{it})
    val arr = ArrayList<String>()
    val N = readLine().toInt()
    repeat(N){
        val str = readLine()
        pq.add(str)
        arr.add(str)
    }

//    arr.sortWith(compareBy<String>{it.length}.thenBy{it.parsingInt()}.thenBy{it})

    repeat(N){ i ->
        val str = pq.poll()
        bw.append("$str\n")
    }

    bw.flush()
}