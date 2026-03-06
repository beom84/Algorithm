private fun main() = with(System.`in`.bufferedReader()){
    val  k = readLine().toInt()
    var sum = 0
    val stack = ArrayDeque<Int>()

    repeat(k){
        val num = readLine().toInt()

        if(num != 0)stack.addLast(num) else stack.removeLast()
    }

    stack.forEach{n -> sum += n}

    print(sum)
}