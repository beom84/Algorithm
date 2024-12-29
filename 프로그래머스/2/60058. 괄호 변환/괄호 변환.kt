class Solution {
    fun solution(p: String): String {
        var answer = ""
        var u = ""
        var v = ""
        var count = 0
        if (p.isEmpty()) return p //재귀함수 종료
        val c = p[0]
        for (i in p.indices) {
            if (p[i] == c) {
                count++
            } else {
                count--
            }
            if (count == 0) {
                u = p.substring(0..i)
                v = if (u == p) "" else p.substring(i + 1)
                break
            }
        }

        if (checkRightString(u))
            answer = u + solution(v)
        else {
            answer += "(" + solution(v) + ")"
            val reversed = u.substring(1 until u.lastIndex).map {
                if (it == '(') return@map ")" else return@map "("
            }
            
            answer += reversed.joinToString ("")
        }
        println(answer)
        return answer
    }

    private fun checkRightString(p: String): Boolean {
        val end = p.lastIndex
        for (i in 0 until (end + 1) / 2) {
            if (p[0] != '(' && p[end - i] != ')')
                return false
        }
        return true
    }
}
