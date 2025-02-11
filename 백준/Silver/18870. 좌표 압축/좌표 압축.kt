fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val xCoordinates = Array(n) { 0 to 0 }
    val answer = Array(n) { 0 to 0 }
    val temp = Array(n) { 0 to 0 }
    val sb = StringBuilder()

    readLine().split(" ").mapIndexed { idx, x ->
        xCoordinates[idx] = Pair(x.toInt(), idx)
    }


    mergeSorting(xCoordinates, temp, 0, xCoordinates.lastIndex)

    var count = 0
    answer[0] = Pair(0, xCoordinates[0].second)
    for (i in 1..xCoordinates.lastIndex) {
        if (xCoordinates[i].first != xCoordinates[i - 1].first) count++
        answer[i] = Pair(count, xCoordinates[i].second)
    }

    answer.sortWith(compareBy { it.second })

    for (i in answer) sb.append("${i.first} ")

    println(sb.toString())
}

fun mergeSorting(array: Array<Pair<Int, Int>>, temp: Array<Pair<Int, Int>>, start: Int, end: Int) {
    val mid = (start + end) / 2

    if (start < end) {
        mergeSorting(array, temp, start, mid)
        mergeSorting(array, temp, mid + 1, end)
        merging(array, temp, start, mid + 1, end)
    }
}

fun merging(arr: Array<Pair<Int, Int>>, temp: Array<Pair<Int, Int>>, start: Int, mid: Int, end: Int) {
    var tempPos = start
    var left = start
    var right = mid
    while (left <= mid - 1 && right <= end) {
        if (arr[left].first <= arr[right].first) temp[tempPos] = arr[left++]
        else temp[tempPos] = arr[right++]

        tempPos++
    }

    while (left <= mid - 1) temp[tempPos++] = arr[left++]

    while (right <= end) temp[tempPos++] = arr[right++]

    for (i in start..end) arr[i] = temp[i]
}