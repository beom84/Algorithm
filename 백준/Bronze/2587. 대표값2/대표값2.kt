fun main() = with(System.`in`.bufferedReader()){
    val arr = Array(5){readLine().toInt()}
    var sum = 0

    for(i in 0 .. 2){
        var min = i
        for(j in i+1 .. arr.lastIndex){
            if(arr[min] > arr[j])
                min = j
        }
        val temp = arr[min]
        arr[min] = arr[i]
        arr[i] = temp
    }

    for(i in arr) sum += i

    println("${sum/5}\n${arr[2]}")
}