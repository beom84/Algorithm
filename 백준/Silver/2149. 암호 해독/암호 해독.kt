private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val key = readLine()
    val value = readLine()
    val keyLength = key.length
    val listSize = value.length / key.length

    val arr = Array(keyLength) { ArrayList<Char>() }
    // 키를 정렬하고  정렬된걸 arr에 먼저 넣는다.
    val sortedKey = key.toCharArray().sortedWith(compareBy<Char> { it })
    for ((i, k) in sortedKey.withIndex()) {
        arr[i].add(k) // 0에 key 추가
    }

    //순서대로 배열을 처음부터 각각의 배열에 넣고싶다.
    for (i in 0 until keyLength) {
        for (j in 0 until listSize) {
            arr[i].add(value[i * listSize + j])        }
    }

    //정렬한 키를 원위치에 돌려놓는다.
    val answer = Array(key.length) { ArrayList<Char>() }
    val visited = BooleanArray(key.length)

    for ((i, k) in key.withIndex()) { // 키값 // 키에 대해서 앞에서부터 찾을거야
        for (j in arr.indices) { // 정렬된 키중에 나랑 같은거를 찾아야한다.
            //찾으면 visited
            if (visited[j]) continue
            val sortedK = arr[j][0]
            if (sortedK == k) {
                answer[i]=(arr[j])
                visited[j] = true
                break
            }
        }
    }

    //x -> y 순서대로 출력
    for (y in 1..answer[0].lastIndex) {
        for (x in answer.indices) {
            bw.append("${answer[x][y]}")
        }
    }


    bw.flush()
}
