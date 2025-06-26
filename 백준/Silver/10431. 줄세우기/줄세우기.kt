import java.util.*

private val bw = System.`out`.bufferedWriter()
var count = 0

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val tcNum = st.nextToken()
        val studentList = ArrayList<Int>()
        studentList.add(st.nextToken().toInt())
        while (st.hasMoreTokens()) {
            val num = st.nextToken().toInt()
            studentList.add(num)
            var newStudentIdx = studentList.lastIndex
            var idx = newStudentIdx - 1
            while (idx != -1 && studentList[idx--] > num) {
                val temp = studentList[idx + 1]
                studentList[idx + 1] = studentList[newStudentIdx]
                studentList[newStudentIdx] = temp
                newStudentIdx--
                count++
            }
        }
        bw.append(tcNum).append(" $count").append("\n")
        count = 0
    }
    bw.flush()
}
