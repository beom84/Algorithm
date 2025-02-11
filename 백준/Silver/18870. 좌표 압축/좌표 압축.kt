fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    val xCoordinates = readLine().split(" ").map { it.toInt() }
    val sortedArr = xCoordinates.distinct().sorted()
    val hasMap = HashMap<Int,Int>()
    var count = 0
    
    sortedArr.forEach { 
        hasMap[it] = count++
    }
    
    for(i in 0 until n) sb.append("${hasMap[xCoordinates[i]]} ")

    println(sb)
}