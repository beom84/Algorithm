fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = readLine().split(" ").map { it.toInt() }
    var sum = array[0]
    var max = sum

    for (i in 1..array.lastIndex) {
        if (sum < 0) {
            sum = if (array[i] < 0 && array[i] <= sum) sum else array[i]
        }else {
            sum += array[i]
            if(sum < 0) sum = 0
            if(max < sum ) max = sum
        }
    }
    println(if(sum<0)sum else max)
}