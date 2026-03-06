class Solution {
    fun solution(numbers: LongArray): LongArray {
      return numbers.map { x ->
        if (x % 2 == 0L) {
            // 1. 짝수 (x의 LSB가 0)
            // LSB인 0을 1로 바꾸면 비트 1개만 다름 (x + 1)
            x + 1
        } else {
            // 2. 홀수 (x의 LSB가 1)
            // 비트 1개만 다른 수는 불가능. 비트 2개 다른 최소의 수를 찾아야 함.
            
            // a. 가장 오른쪽 0 찾기 (Rightmost Zero Bit)
            // x의 모든 비트를 반전시킨 후, 가장 오른쪽 1의 위치 (trailing zeros)를 찾음.
            // 예: x=7(0111), ~x=(1000...1000) -> trailingZeros=3 (0부터 시작)
            val n: Int = (x.inv()).and(Long.MAX_VALUE).countTrailingZeroBits() // x의 trailing zeros는 0이지만, ~x의 trailing zeros는 가장 오른쪽 0의 위치를 알려줌.

            // b. 0 -> 1로 바꿀 마스크 (1 shl n)
            // n번째 비트(0이었던 곳)를 1로 설정 (or 연산)
            val addMask: Long = 1L.shl(n)

            // c. 1 -> 0으로 바꿀 마스크 (1 shl (n-1))
            // n-1번째 비트(1이었던 곳)를 0으로 설정 (xor 연산)
            val removeMask: Long = 1L.shl(n - 1)

            // 최종 f(x) 값
            // 1. x에 addMask를 OR 연산하여 0이었던 n번째 비트를 1로 바꿈
            // 2. n-1번째 비트(1이었던 곳)를 0으로 바꾸기 위해 XOR 연산함
            val fx = x.or(addMask).xor(removeMask)
            
            fx
        }
    }.toLongArray()
    }
    
}