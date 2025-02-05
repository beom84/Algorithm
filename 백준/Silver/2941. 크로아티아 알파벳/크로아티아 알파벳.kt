fun main() = with(System.`in`.bufferedReader()) {
    var count = 0
    var index = 0
    val str = readLine()
    
    while (index < str.length) {
        if ( index <= str.length - 2) {
            when (str[index]) {
                'c' -> if (str[index + 1] == '=' || str[index + 1] == '-') index++

                'd' -> if (str[index + 1] == '-') index++ else if (index <= str.length - 3 && str[index + 1] == 'z' && str[index + 2] == '=') index += 2

                'l' -> if (str[index + 1] == 'j') index++

                'n' -> if (str[index + 1] == 'j') index++

                's' -> if (str[index + 1] == '=') index++

                'z' -> if (str[index + 1] == '=') index++
            }
        }
        index++
        count++
    }

    println(count)
}