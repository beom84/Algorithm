package baekjoon.silver

import kotlin.math.abs

/***
 * 제약조건 확인
 * - 복잡도 제한
 *      2초 / 512MB
 * - 입력조건
 *      1 -> N(4 ≤ N ≤ 20, N은 짝수
 *      2~N -> S
 *          - 각 줄은 N개의 수로 이루어져 있고, i번 줄의 j번째 수는 Sij 이다
 *          - Sii = 0 /  1<= Sij < 100
 * - 예외 케이스
 *
 * 문제 정의
 * 사람에게 1~N으로 번호를 부여
 * Sij는 i번 ,j번이 같은 팀일시 팀에 더해지는 능력치
 * 팀의 능력치 : 팀에 속한 모든 Sij 의합
 * Sji != Sij
 * 목표 : 두팀의 능력치가 0에 가깝도록 만들고 최소값을 출력하시오
 * 모든 경우의 수중에 2팀으로 나뉘었을떄 가장 적은 경우를 구해라
 * -> N명을 골랐을떄 N/2!이 worst->
 *
 * 알고리즘 후보
 * - 한팀을 정하면 나머지 한팀은 정해진다.
 * - 모든 팀구성을 정해서 계산하고 비교한다. -
 * - 반대팀에 포함이 안되려면 -> 내가 한 조합의 반대 조합을 계산하면 안된다
 *      - 1을 start팀에 포함시킨다.
 *      - 논리적으로 설명이 안되노.. -> 그치만 한개를 포함시키고 시작하는건 맞다.
 * - 브루트 포스틀 통해 오름차순으로 모두 진행하고 가장 적은 수를 출력한다.
 *
 * 자료구조 후보
 * - 정해진 배열 크기 , 값이 자주 바뀐다.
 *      - IntArray
 *
 * 타당성 체크
 * - 요구조건
 *      다 출력하는데 어케안되노
 * 복잡도 여부
 * - N-1CN/2 * N/2 P 2 -> Logn?
 *

 */


import java.util.StringTokenizer
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val board = Array(N) { IntArray(N) }

    // 1. 입력부 수정 (4 -> N)
    repeat(N) { x ->
        val st = StringTokenizer(readLine())
        for (y in 0 until N) {
            board[x][y] = st.nextToken().toInt()
        }
    }

    val visited = BooleanArray(N)
    var minDiff = Int.MAX_VALUE

    // 2. 백트래킹 함수 (index 파라미터 추가 -> 조합 구현)
    fun chooseTeam(index: Int, depth: Int) {
        // [Base Case] 팀원 N/2명을 모두 뽑았을 때
        if (depth == N / 2) {
            var startStat = 0
            var linkStat = 0

            // 3. 점수 계산 (이중 for문으로 모든 쌍 검사)
            for (i in 0 until N - 1) {
                for (j in i + 1 until N) {
                    if (visited[i] && visited[j]) {
                        // 둘 다 방문했다면 Start 팀
                        startStat += board[i][j] + board[j][i]
                    } else if (!visited[i] && !visited[j]) {
                        // 둘 다 방문 안 했다면 Link 팀
                        linkStat += board[i][j] + board[j][i]
                    }
                }
            }

            minDiff = min(minDiff, abs(startStat - linkStat))

            // 최적화: 차이가 0이면 더 볼 필요 없음 (바로 종료)
            if (minDiff == 0) {
                println(0)
                System.exit(0)
            }
            return
        }

        // [Recursive Step]
        // i는 index부터 시작 (이게 핵심! 중복 방지)
        for (i in index until N) {
            if (!visited[i]) {
                visited[i] = true
                chooseTeam(i + 1, depth + 1) // 다음 재귀는 i+1부터 탐색
                visited[i] = false
            }
        }
    }

    // 초기 설정: 0번 선수는 무조건 포함시키고 시작 (경우의 수 절반 감소)
    // 사실 그냥 chooseTeam(0, 0) 해도 되지만, 님의 아이디어가 좋아서 살림
    visited[0] = true
    chooseTeam(1, 1) // 1번 선수부터 탐색 시작, 현재 1명(0번) 뽑은 상태

    println(minDiff)
}
