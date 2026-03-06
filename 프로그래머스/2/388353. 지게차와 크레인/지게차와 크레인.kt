import java.util.*

class Solution {
    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,1,0,-1)
    fun solution(storage: Array<String>, requests: Array<String>): Int {
        val n = storage.size // 세로
        val m = storage[0].length // 가로
        val board = Array(n+2){i -> CharArray(m+2){j -> 
                if(i != 0 && j!=0 && i!=n+1 && j!=m+1){
                storage[i-1][j-1]
                }else{
                    '0'
                }
            }
        }
        
        fun scoop(co : Char){
            val q = ArrayDeque<Int>()
            val visited = Array(n+2){ BooleanArray(m+2)}
            q.add(0)
            while(q.isNotEmpty()){
                val c = q.poll()
                val cx = c / 1000
                val cy = c % 1000
                
                for(i in 0..3){
                    val nx = cx + dx[i]
                    val ny = cy + dy[i]
                    
                    if(nx !in 0 .. n+1 || ny !in 0 .. m+1) continue
                    if(board[nx][ny] == '0' && !visited[nx][ny]) {
                        visited[nx][ny] = true
                        q.add(nx*1000+ny)
                        continue
                    }// q가 방문하지 않은 0일경우 넣기
                    if(board[nx][ny]==(co)) {
                        board[nx][ny] = '0'
                        visited[nx][ny] = true
                    }
                }
            }
        }
        
        fun pork(c : Char){
            for(i in board.indices){
                for(j in board[0].indices){
                    if(board[i][j] == c) board[i][j] = '0'
                }
            }
        }
        
        fun count() : Int{
            var count = 0
            for(i in board.indices){
                for(j in board[0].indices){
                    if(board[i][j] != '0') count++
                    print("${board[i][j]} ")
                }
                println()
            }
            return count
        }
        
        for(command in requests){
            if(command.length == 1){
                scoop(command[0])
            }else{
                pork(command[0])
            }
        }
        return count()
    }
}
/*
알고리즘
- bfs 아닐까?
크레인 -> 해당 알파벳을 모두 '0' 으로 교체
지게차 ->  0을 모두 확인하고  bfs 존재하면 0으로 교체
storage[i][j] -> 컨테이너의 종류 / 알파벳 대문자.
request : 100 개 이하


 접근이 가능하다 : 4면중 적어도 1면이 창고 외부와 연결됨
 크레이을 사용하면 요청된종류의  모든 컨테이너를 꺼낸다.
 한개의 알파벳 : 지게차를 상요해 출고요청이 들어오고 접근가능한 컨테이너꺼냄
 2개의        : 크레인을 사용해 모든 컨테이너
 
 모든 요청을 순서대로 완료한 후 남은 컨테이너의 수
 
*/