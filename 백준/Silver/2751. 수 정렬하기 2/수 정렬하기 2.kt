fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val num = br.readLine().toInt()
    val arr = IntArray(num) { br.readLine().toInt() }

    mergeSort(arr, 0, num - 1)

    arr.forEach {
        bw.append("$it\n")
    }

    bw.write("")
    bw.flush()
    bw.close()
    br.close()
}

fun mergeSort(data: IntArray, start: Int, end: Int) {
    if(start>=end) return

    val mid = (start+end)/2 // 배열을 반으로 분할

    mergeSort(data, start, mid) // 재귀
    mergeSort(data, mid + 1, end) // 재귀

    merge(data, start, mid, end) // 분할된 두 배열 병합
}

val tmp = IntArray(1000000) // 정렬될 배열

fun merge(data: IntArray, start: Int, mid: Int, end: Int) {
    var leftStart = start // 왼쪽 배열 인덱스
    var rightStart = mid + 1 // 오른쪽 배열 인덱스
    var idx = start // 정렬될 배열의 인덱스

    while (leftStart <= mid && rightStart <= end) { // 두 배열 중 한쪽을 새로운 배열에 담을 수 없으면 종료
        // 둘 중 최솟값을 배열에 담아줌
        if (data[leftStart] > data[rightStart]) {
            tmp[idx++] = data[rightStart]
            rightStart++
        } else if (data[leftStart] <= data[rightStart]) {
            tmp[idx++] = data[leftStart]
            leftStart++
        }
    }

    if (leftStart > mid) { // 오른쪽 배열 원소가 남아 있는 경우
        for (i in rightStart..end) {
            tmp[idx++] = data[i]
        }
    }

    if (rightStart > end) { // 왼쪽 배열의 원소가 남아 있는 경우
        for (i in leftStart..mid) {
            tmp[idx++] = data[i]
        }
    }

    for (i in start..end) { // 원래의 배열에 대입
        data[i] = tmp[i]
    }
}