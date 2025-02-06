fun main() = with(System.`in`.bufferedReader()) {
    var scoreSum = 0.0
    var gradeSum = 0.0

    for (i in 0..19) {
        val subjectInfo = readLine().split(" ")
        val score = subjectInfo[1].toDouble()
        if(subjectInfo[2] !="P") {
            gradeSum += score * getScore(subjectInfo[2])
            scoreSum += score
        }
    }
    print(gradeSum / scoreSum)
}

fun getScore(grade: String) : Double{
    return when(grade){
        "A+" -> 4.5
        "A0" -> 4.0
        "B+" -> 3.5
        "B0" -> 3.0
        "C+" -> 2.5
        "C0" -> 2.0
        "D+" -> 1.5
        "D0" -> 1.0
        else -> 0.0
    }
}