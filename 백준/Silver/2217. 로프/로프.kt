import kotlin.math.max

private fun main() = with(System.`in`.bufferedReader()){
    val n  = readLine().toInt()
    val ropes = IntArray(n)

    repeat(n){ i->
        ropes[i] = readLine().toInt()
    }

   val rope = ropes.sortedWith(compareBy { it })

    var max = 0
    var count = n

    for(i in rope.indices){
        max = max(max,rope[i]*count--)
    }

    println(max)
}
