import java.util.*
private val bw =System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    val pq = PriorityQueue<String>(compareBy<String>{it.length}.thenBy{it})
    val set = mutableSetOf<String>()
    val a = ArrayList<String>(N)
    // 자료구조 다시보자

    repeat(N){
        val str = readLine()
        if(!set.contains(str)) {
            set.add(str)
            pq.add(str)

            a.add(str)
        }
    }

    a.sortWith(compareBy<String>{it.length}.thenBy{it})

    for(str in a){
        bw.append(str).append("\n")
    }

    bw.flush()
}