fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    var index = 0

    val circle = ArrayList<Int>()
    repeat(n) { idx ->
        circle.add(idx, idx + 1)
    }

    sb.append("<")
    repeat(n) { idx ->
        index = (index + k - 1) % circle.size
        val peopleNum = circle[index]
        circle.removeAt(index)
        if (idx != n - 1)
            sb.append(peopleNum).append(", ")
        else
            sb.append(peopleNum).append(">")
    }

    println(sb)
}