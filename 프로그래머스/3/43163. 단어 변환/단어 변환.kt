class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        val length = begin.length
        val correctIdx = BooleanArray(length)
        val visited = BooleanArray(words.size)
        val queue = ArrayDeque<Pair<String,Int>>()
        val remainWords = words       
        
        fun bfs(){ // 체크하고 맞다면 queue.에 집어넣기 아니면 빼기 dfs?
            
            while(!queue.isEmpty()){
                val current = queue.removeFirst()
                val currentStr = current.first
                val count = current.second
                
                if(currentStr == target){
                    answer = count
                    break
                } 
                
                  // 같은걸 찾는 함수
                        for(i in remainWords.indices){ // 단어에 대해서
                                if(visited[i]) continue
                                val str = remainWords[i]
                                if(!checkEqual(currentStr,str)) continue // 1개만 같다면 여기로 큐에넣
                                queue.addLast(str to count+1)

                                visited[i] = true
                            
                }
            // visited를 통해 맞지 않는 
             }
        }
        
        queue.addLast(begin to 0)
        bfs()

        return answer
    }
    
    fun checkEqual(a:String,b:String): Boolean{
        var isEqual = false
        var check = false
       for(i in a.indices){
           if(a[i] != b[i]) {
               if(!check)check = true 
               else return false
           }
       }
        return true
    }
    
}
/*
 제약조건
 - 입력조건
 1. begin -> target으로 변하는데 이때 words냉 있는거만 사용가능하다.
 words 내에 모든 단어의 길이가 같다.
 - 예외케이스
  변환할수 없는 경우 0을 return
  words에는 3개 이상 50개 이하의 단어가 존재 (중복 x)
  begin != target
 
 문제정의
 - begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려한다
 - 한번에 한개의 알파벳만 바꿀수 있고 words에 있는 단어로만 가능하다.
 
 알고리즘
 - 결국 begin의 크기만큼 같은걸 찾는거야. 각 알파벳이 변하는 최소의 길이를 찾아라.
    - 이때 한개만 달라야한다.
     -앞에 시행한게 뒤에 영향을 끼쳐? 아니요 . 그럼 그떄그떄 최선의 결과를 내야하는거네. 모든걸 다해서
        - hot cot got gog cog
     - 그러면 한개만 다른걸 어떻게 찾을거야?
        - 내가 목표한 알파벳과 똑같은걸 찾는다.
        - 다른걸 같은지 확인한다.
    - 다해보는걸 어떻게 효율적으로 할까?
 타당성
 - 
*/