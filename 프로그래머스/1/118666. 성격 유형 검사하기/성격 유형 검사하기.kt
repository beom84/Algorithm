class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
    val personalType = mutableMapOf(
        "R" to 0, "T" to 0,
        "C" to 0, "F" to 0,
        "J" to 0, "M" to 0,
        "A" to 0, "N" to 0
    )

    for (i in choices.indices) {
        val choice = choices[i]
        when {
            (choice == 4) ->
                continue

            (choice < 4) ->
                personalType[survey[i][0].toString()] = personalType[survey[i][0].toString()]!! + (4 - choice)

            else ->
                personalType[survey[i][1].toString()] = personalType[survey[i][1].toString()]!! + choice - 4
        }
    }
    val answer = buildString {
        append(if (personalType["R"]!! < personalType["T"]!!) "T" else "R")
        append(if (personalType["C"]!! < personalType["F"]!!) "F" else "C")
        append(if (personalType["J"]!! < personalType["M"]!!) "M" else "J")
        append(if (personalType["A"]!! < personalType["N"]!!) "N" else "A")
    }
    return answer
}
}