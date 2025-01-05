fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (N, M) = readLine().split(" ").map ( String::toInt )
        val aType = readLine().split(" ").map ( String::toInt ).sorted()
        val bType = readLine().split(" ").map ( String::toInt ).sorted()
        var answer = 0
        for (a in aType) {
            var (l, r) = 0 to M - 1
            var target = -1
            while (l <= r) {
                val m = (l + r).div(2)

                if (bType[m] <= a) {
                    l = m + 1
                    target = m
                } else {
                    r = m - 1
                }
            }

            while (target >= 0 && bType[target] == a) {
                target--
            }
            answer += target + 1
        }
        println(answer)
    }
}