fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val location = Array(N) {0 to 0}
    repeat(N){ idx->
        val (x,y) = readLine().split(" ").map { it.toInt() }
        location[idx] = Pair(x,y)
    }

    val temp = Array(N) { 0 to 0 }

    mergeSort(location, temp, 0, location.lastIndex)

    for (i in location) println("${i.first} ${i.second}")
}

fun mergeSort(arr: Array<Pair<Int, Int>>, temp: Array<Pair<Int, Int>>, start: Int, end: Int) {
    val mid = (start + end) / 2

    if (start < end) {
        mergeSort(arr, temp, start, mid)
        mergeSort(arr, temp, mid+1, end)
        merge(arr, temp, start, mid+1, end)
    }
}

fun merge(arr: Array<Pair<Int, Int>>, temp: Array<Pair<Int, Int>>, start: Int, mid: Int, end: Int) {
    var tempPos = start
    var left = start
    var right = mid
    while (left <= mid - 1 && right <= end) {
        if (arr[left].first < arr[right].first) temp[tempPos] = arr[left++]
        else if (arr[left].first == arr[right].first) {
            if (arr[left].second < arr[right].second) {
                temp[tempPos] = arr[left]
                left++
            } else {
                temp[tempPos] = arr[right]
                right++
            }
        } else {
            temp[tempPos] = arr[right]
            right++
        }
        tempPos++
    }

    while (left <= mid - 1) temp[tempPos++] = arr[left++]

    while (right <= end) temp[tempPos++] = arr[right++]

    for (i in start..end) arr[i] = temp[i]
}