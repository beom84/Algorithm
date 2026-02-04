package baekjoon.gold

/*
 제약조건
 - 복잡도 : 2초 512
 - 입력조건
 1 -> N(세로크기) M(가로크기) (3 ≤ N, M ≤ 8)
 2~ N -> 지도의 모양
 0 : 빈칸(최소 3개 이상) / 1 : 벽 / 2 : 바이러스의 위치 (1보다 크고 11보다 작다)
 - 예외 케이스

 문제 정의
 - board는 빈 칸,벽으로 이루어져있다. 어떤 칸은 바이러스가 존재하고 해당 바이러스는 상하 좌우로 퍼져나갈수 있다.
 - 빈칸에 벽을 반드시 3개를 세워서 바이러스가 퍼질수 없는 안전영역의 최대 크기를 구하여라

 알고리즘
 - 여러개의 빈칸중에 3개를 골라서 벽을 두어야한다.
 - 해당 벽을 통해 안전영역의 최대 값을 구해야한다.
 - 벽을 세워봐야 바이러스가 어디까지 퍼지는지 알수 있다. vs 바이러스가 퍼지기 전에 벽을 세운다 vs 퍼지는 도중에 세운다.
 - 벽을 세우고 , 바이러스를 퍼트려본다(O(64) 그리고 바이러스가 퍼진 구역 + 벽을 뺀다.
 1. 조합
    - 1보다 64c3 -> 안터진다
        2. bfs를 통한 안전지대 확인

  자료구조
  - bard : Array<IntArray>
  - queue : 바이러스 bfs 용
  - safeSpace : 안전지대 크기
  - maxSafeSpace : 최소 안전지대 크기

  타당성
  - 복잡도 괜찮음
  - bfs니까 시간도 괜찮음
 */
import java.util.*

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val board = Array(N + 1) { IntArray(M + 1) { Int.MAX_VALUE } } // 0 버리기


    val virus = ArrayDeque<Pair<Int, Int>>() // 바이러스요
    var maxSafeSpace = 0

    //board 저장
    repeat(N) { x ->
        val st = StringTokenizer(readLine())
        repeat(M) { y ->
            board[x + 1][y + 1] = st.nextToken().toInt()
            if (board[x + 1][y + 1] == 2) virus.addLast(x + 1 to y + 1) // 바이러스 위치 저장
        }
    }

    //bfs 를 통해 벽의 개수 세기
    fun bfs(bBoard: Array<IntArray>): Int {
        val queue = virus.clone()
        val newBoard = Array(N + 1) { i -> bBoard[i].clone() }


        while (!queue.isEmpty()) {
            val current = queue.removeFirst()
            val cx = current.first
            val cy = current.second
            for (i in 0..3) {
                val nx = cx + dx[i]
                val ny = cy + dy[i]

                if (nx > N || ny > M || nx <= 0 || ny <= 0) continue
                if (newBoard[nx][ny] == 0) {
                    newBoard[nx][ny] = 2
                    queue.addLast(nx to ny)
                }
            }
        }
        var safeSpace = 0


        for (i in 1..board.lastIndex) {
            safeSpace += newBoard[i].filter { num -> num == 0 }.size
        }
        return safeSpace
    }
    //board는 밖에서 새로 만들자

    val newBoard = Array(N + 1) { i -> board[i].clone() }

    //모든 0에 벽을 세워봐야한다. -> 백트래킹 조합
    fun backTracking(depth: Int, x: Int, y: Int) {
        if (depth == 3) {
            val safeSpace = bfs(newBoard)
            maxSafeSpace = Math.max(safeSpace, maxSafeSpace)

            return
        }
        // 만약 ny가 M을 넘는다면?
        // x가 더 필요할수도 y가 더필요할수도 있네
        for (nx in x..N) {
            for (ny in 1..M) {
                if(nx == x && ny < y) continue
                if (nx > N || ny > M || nx <= 0 || ny <= 0) continue
                if (newBoard[nx][ny] == 1 || newBoard[nx][ny] == 2) continue


                newBoard[nx][ny] = 1

                if (ny + 1 <= M) {
                    backTracking(depth + 1, nx, ny + 1)
                } else {
                    backTracking(depth + 1, nx + 1, 0)
                }
                newBoard[nx][ny] = 0
            }
        }
    }
    backTracking(0, 1, 0)
    println(maxSafeSpace)
}