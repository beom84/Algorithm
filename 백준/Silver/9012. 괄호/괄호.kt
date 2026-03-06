import java.util.*

private val bw = System.`out`.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()){
    val T = readLine().toInt()
    repeat(T){
        //stack에 넣고 만약 stack이 차있으면 NO
        val st = ArrayDeque<Char>()
        val line = readLine()

        for(a in line){
            if(a == '('){
                st.addLast(a)
            }else{
                if(st.isEmpty()) {
                    st.addLast(a)
                    break
                }
                st.removeLast()
            }
        }
        val answer = if(st.isEmpty())"YES" else "NO"
        bw.append(answer).append("\n")
    }
    bw.flush()
}