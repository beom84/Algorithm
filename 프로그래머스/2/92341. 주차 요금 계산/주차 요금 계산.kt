import kotlin.math.ceil

class Solution {
   fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray
        val basicTime = fees[0]
        val basicFee = fees[1]
        val unitTime = fees[2]
        val unitFee = fees[3]
        val defaultExitTime = 60 * 23 + 59
        val carDepartureRecords = mutableMapOf<String, Pair<Int, Int>>()
        val totalTime = mutableMapOf<String, Int>()

        records.forEach {
            val record = it.split(" ")
            val departureTime = timeToMinute(record[0])
            val carNumber = record[1]
            val departureStatus = if (record[2] == "IN") 1 else 0

            if (departureStatus == 1) {
                carDepartureRecords[carNumber] = departureTime to departureStatus
            } else {
                val entryTime = carDepartureRecords.getValue(carNumber).first
                totalTime[carNumber] = (departureTime - entryTime) + (totalTime[carNumber] ?: 0)
                carDepartureRecords.remove(carNumber)
            }
        }

        carDepartureRecords.forEach {
            totalTime[it.key] = defaultExitTime - it.value.first + (totalTime[it.key] ?: 0)
        }

        answer = totalTime.keys.sorted().map {
            calculateTotalFee(basicTime, basicFee, unitTime, unitFee, totalTime.getValue(it))
        }.toIntArray()

        return answer
    }

    fun timeToMinute(time: String): Int {
        val stringHour = time.split(":")[0]
        val hour =
            when {
                stringHour.startsWith("0") -> stringHour.substring(1).toInt()
                else -> stringHour.toInt()
            }

        val minute = time.split(":")[1].toInt()
        return hour * 60 + minute
    }

    fun calculateTotalFee(basicTime: Int, basicFee: Int, unitTime: Int, unitFee: Int, totalTime: Int): Int {
        var totalFee: Int
        val extraTime = (totalTime - basicTime) / (unitTime.toDouble())
        if (totalTime < basicTime) return basicFee
        else {
            totalFee = basicFee + ceil(extraTime).toInt() * unitFee
            return totalFee
        }
    }
}