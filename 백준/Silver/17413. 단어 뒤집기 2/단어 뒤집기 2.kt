import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val strings = readLine()
    val sb = StringBuilder()
    var isTagged = false
    var word = StringBuilder()

    for (char in strings) {
        when (char) {
            '<' -> {
                sb.append(word.reverse())  // 단어 뒤집어서 추가
                word.clear()  // 단어 초기화
                isTagged = true  // 태그 내부 시작
                sb.append(char)  // '<' 추가
            }

            '>' -> {
                isTagged = false  // 태그 종료
                sb.append(char)  // '>' 추가
            }

            ' ' -> {
                if (isTagged) {
                    sb.append(char)  // 태그 내부의 공백은 그대로 추가
                } else {
                    sb.append(word.reverse()).append(' ')  // 단어 뒤집고 공백 추가
                    word.clear()  // 단어 초기화
                }
            }

            else -> {
                if (isTagged) {
                    sb.append(char)  // 태그 내부 문자 그대로 추가
                } else {
                    word.append(char)  // 단어 저장
                }
            }
        }
    }

    sb.append(word.reverse())  // 마지막 남은 단어 추가
    println(sb)  // 최종 출력
}