
import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val left = listOf(1, 4, 7)
        val right = listOf(3, 6, 9)
        val handLocation = IntArray(2)
        handLocation[0] = 9
        handLocation[1] = 11
        numbers.forEach { number ->
            val actualNumber = if (number == 0) 10 else number - 1

            when {
                left.contains(number) -> {
                    answer += "L"
                    handLocation[0] = actualNumber
                }

                right.contains(number) -> {
                    answer += "R"
                    handLocation[1] = actualNumber
                }

                else -> {
                    val leftSide = Pair(handLocation[0] / 3, handLocation[0] % 3)
                    val rightSide = Pair(handLocation[1] / 3, handLocation[1] % 3)
                    val numberLocation = Pair(actualNumber / 3, actualNumber % 3)

                    val leftDistance =
                        abs(leftSide.first - numberLocation.first) + abs(leftSide.second - numberLocation.second)
                    val rightDistance =
                        abs(rightSide.first - numberLocation.first) + abs(rightSide.second - numberLocation.second)

                    if (rightDistance < leftDistance) {
                        answer += "R"
                        handLocation[1] = actualNumber
                    } else if (rightDistance > leftDistance) {
                        answer += "L"
                        handLocation[0] = actualNumber
                    } else {
                        if (hand == "left") {
                            answer += "L"
                            handLocation[0] = actualNumber
                        } else {
                            answer += "R"
                            handLocation[1] = actualNumber
                        }
                    }
                }
            }
        }
        return answer
    }
}