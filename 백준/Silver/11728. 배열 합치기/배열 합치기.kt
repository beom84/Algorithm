private val bw = System.`out`.bufferedWriter()
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr1 = readLine().split(" ").map { it.toInt() }
    val arr2 = readLine().split(" ").map { it.toInt() }
    var index1 = 0
    var index2 = 0

    while (index1 != n && index2 != m) {
        if (arr1[index1] < arr2[index2]) {
            bw.write("${arr1[index1]} ")
            index1++
        } else {
            bw.write("${arr2[index2]} ")
            index2++
        }
    }

    if (index1 != n) {
        for (i in index1..arr1.lastIndex) {
            bw.write("${arr1[index1]} ")
            index1++
        }
    } else {
        for (i in index2..arr2.lastIndex) {
            bw.write("${arr2[index2]} ")
            index2++
        }
    }
    bw.flush()
    bw.close()
}