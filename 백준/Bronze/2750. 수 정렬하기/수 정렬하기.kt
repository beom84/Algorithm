fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n) { readLine().toInt() }

    bubbleSort(arr)

    for (i in arr) println(i)
}

fun bubbleSort(arr: IntArray) {
    if (arr.size == 1) return
    var swapped: Boolean
    for (i in 0 until arr.lastIndex) {
        swapped = false
        for (j in 0 until arr.lastIndex - i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j + 1]
                arr[j + 1] = arr[j]
                arr[j] = temp
                swapped = true
            }
        }
        if (!swapped) break
    }
}