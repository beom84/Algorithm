class Solution {
    fun solution(s: String): Int {
       var answer: Int = 0
        var result = ""
        var numStr = ""
        val numberMap = mapOf(
            "zero" to "0",
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )
        val numbers = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        for (i in s.indices) {
           if (numberMap.containsValue(s[i].toString() as Any)) {
                result += s[i].toString()
                   continue
           }
            else {
                numStr += s[i].toString()
               if (numberMap.containsKey(numStr)) {
                   result += numberMap[numStr]!!
                   numStr = ""
               }
           }
        }
        answer = result.toInt()
        return answer
    }
}