fun main() = with(System.`in`.bufferedReader()) {
    var count = 0
    var index = 0
    val str = readLine()
    val changedList = listOf('c', 'd', 'l', 'n', 's', 'z')

    while (index < str.length) {
        if (changedList.contains(str[index]) && index <= str.length - 2) {
            when (str[index]) {
                'c' -> {
                    if (str[index + 1] == '=' || str[index + 1] == '-') {
                        count++
                        index += 2
                    }else {
                        index++
                        count++
                    }
                }

                'd' -> {
                    if (str[index + 1] == '-') {
                        count++
                        index += 2
                    } else if (index <= str.length - 3 && str[index + 1] == 'z' && str[index + 2] == '=') {
                        count++
                        index += 3
                    }else {
                        index++
                        count++
                    }
                }

                'l' -> {
                    if (str[index + 1] == 'j') {
                        count++
                        index += 2
                    }else {
                        index++
                        count++
                    }
                }

                'n' -> {
                    if (str[index + 1] == 'j') {
                        count++
                        index += 2
                    }else {
                        index++
                        count++
                    }
                }

                's' -> {
                    if (str[index + 1] == '=') {
                        count++
                        index += 2
                    }else {
                        index++
                        count++
                    }
                }

                'z' -> {
                    if (str[index + 1] == '=') {
                        count++
                        index += 2
                    }else {
                        index++
                        count++
                    }
                }
            }
        } else {
            index++
            count++
        }
    }

    println(count)
}