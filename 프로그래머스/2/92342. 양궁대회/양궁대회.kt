class Solution {
    lateinit var info: IntArray
    var maxDiff = 0
    var bestLionInfo: IntArray = intArrayOf(-1)

    fun solution(n: Int, info: IntArray): IntArray {
        this.info = info
        val lionInfo = IntArray(11) { 0 }
        dfs(0, n, lionInfo)
        return bestLionInfo
    }

    fun dfs(index: Int, remainingArrow: Int, lionInfo: IntArray) {
        if (index == 11 || remainingArrow == 0) {
            // 남은 화살을 마지막에 몰아주기
            if (remainingArrow > 0) {
                lionInfo[10] += remainingArrow
            }

            // 점수 계산
            val (lionScore, apeachScore) = calculateScore(lionInfo)
            val scoreDiff = lionScore - apeachScore

            // 라이언이 이기고, 점수 차이가 최대일 때 갱신
            if (scoreDiff > maxDiff) {
                maxDiff = scoreDiff
                bestLionInfo = lionInfo.copyOf()
            } else if (scoreDiff == maxDiff && scoreDiff > 0) {
                // 점수 차이가 동일한 경우 낮은 점수를 더 많이 맞힌 경우 선택
                if (isBetter(lionInfo, bestLionInfo)) {
                    bestLionInfo = lionInfo.copyOf()
                }
            }

            // 남은 화살 복구
            if (remainingArrow > 0) {
                lionInfo[10] -= remainingArrow
            }
            return
        }

        // 1. 현재 점수를 얻기 위해 필요한 만큼 쏘기
        if (remainingArrow > info[index]) {
            lionInfo[index] = info[index] + 1
            dfs(index + 1, remainingArrow - lionInfo[index], lionInfo)
            lionInfo[index] = 0 // 백트래킹
        }

        // 2. 해당 점수를 포기하기
        dfs(index + 1, remainingArrow, lionInfo)
    }

    fun calculateScore(lionInfo: IntArray): Pair<Int, Int> {
        var lionScore = 0
        var apeachScore = 0

        for (i in 0..10) {
            if (info[i] == 0 && lionInfo[i] == 0) continue
            if (lionInfo[i] > info[i]) lionScore += 10 - i
            else apeachScore += 10 - i
        }

        return Pair(lionScore, apeachScore)
    }

    fun isBetter(lionInfo: IntArray, bestInfo: IntArray): Boolean {
        for (i in 10 downTo 0) {
            if (lionInfo[i] > bestInfo[i]) return true
            if (lionInfo[i] < bestInfo[i]) return false
        }
        return false
    }
}