fun main() = with(System.`in`.bufferedReader()) {
    val info = readLine().split(" ").map { it.toInt() }

    val height = info[2]
    val up = info[0]
    val down = info[1]
    var snail = 0
    
    val count = if ((height - up) % (up - down) != 0) 1 else 0
    snail += (height - up) / (up - down) + count + 1
    
    println(snail)
}