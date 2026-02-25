fun main() = with(System.`in`.bufferedReader()) {
    //s를 char 순서대로 분해한다.
    // t에서 s를 만나는 경우에 count++
    // 마지막에 s가 비어있으면 tru
    var line = ""
   while(true) {
        line = readLine() ?: break
        val (s, t) = line.split(" ")
        var count = 0
        for (c in t) {
            if ( count < s.length && s[count] == c ) count++
        }
        println(if(count == s.length)"Yes" else  "No")
    }
}