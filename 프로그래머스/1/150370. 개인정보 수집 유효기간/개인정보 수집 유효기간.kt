import java.text.SimpleDateFormat
import java.util.Calendar

class Solution {
   fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    val answer = mutableListOf<Int>()

    val df = SimpleDateFormat("yyyy.MM.dd")
    val todayTime = df.parse(today).time
    val termMap: MutableMap<String, Int> = mutableMapOf()
    terms.forEach { tm ->
        val to = tm.split(" ")
        termMap[to[0]] = to[1].toInt()
    }

    privacies.forEachIndexed { idx, privaciy ->
        val cal = Calendar.getInstance()
        cal.time = df.parse(privaciy.split(" ")[0])
        cal.add(Calendar.MONTH, termMap[privaciy.split(" ")[1]]!!)
        cal.add(Calendar.DAY_OF_MONTH, -1)
        if (todayTime > cal.time.time)
            answer.add(idx + 1)
    }

    return answer.toIntArray()
}
}