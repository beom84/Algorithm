/*
 제약조건
 - 입력
 a (길이 :  1 이상 1,000,000 이하)
     a[i]는 i+1 번째 풍선에 써진 숫자를 의미합니다.
     a의 모든 수는 -1,000,000,000 이상 1,000,000,000 이하인 정수입니다.
     a의 모든 수는 서로 다릅니다.
 
 문제정의
 - 1개만 남을떄까지 터트린다.
 1. 인접한 두풍선을 고르고 둘중 한개를 터트린다.
 2. 터진 풍선으로 인해 풍선들 사이에 빈공간이 생겼다면 , 빈공간으로 풍선들을 밀착시킨다.
 - 조건
  번호가 더 작은 풍선을 터트리는 행위는 최대 한번
  따라서 한번 번호가 더 작은 풍선을 터트리면 그이후는 무조건 큰 풍선만 터트릴수 있다.
  
  - 어떤 풍선이 최후까지 남을수 있는지를 확인
  - 1 개까지 터트렸을때 최후까지 남기는게 가능한 풍선의 개수를 구하시오
  
  알고리즘
  - 임의로 두 풍선을 고른다.
  - 둘중 한개를 터트린다. 단, 번호가작은걸 터트린적이 있다면 무조건 큰 풍선을 터트린다.
  - 최후까지 남을 수 있는 풍선은 무엇인가?
  - 1. 양방향다 나보다 작은게 존재하면 불가능
  - 
    이걸 어떻게 확인할까?
    nlogn 2분법 혹은 sorting -> sorting이 편하겠다.
    idx 기준으로 나보다 작은게 존재하는지 확인
    idx가 나보다 작은게 있는가?
*/

class Solution {
    fun solution(a: IntArray): Int {
        var answer: Int = 0
        //크기를 기준으로 sorting되고 idx를 가지는 배열
        val map = mutableMapOf<Int,Int>()
        for(i in a.indices){
            map[a[i]] = i
        }
        
        val sorted = a.sortedWith(compareBy<Int>{it})
        var count = 0
        var leftMin = a[0]
        var idx = 0
        var rightMin = sorted[0]
        for(i in a.indices){
            var stack = 0
            // 왼쪽에 나보다 작은게 존재한다? 혹은 내가 제일 작다면 
            if(a[i] > leftMin) {
                stack++
            }
            else leftMin = a[i]
            //오른쪽에 나보다 작은게 존재한다
            //오른쪽보다 내가 작거나 같다 -> 내가 가장 작은 거임.
            if(a[i] > rightMin) stack++
            else{
                while(true){
                    if(idx == a.lastIndex) break
                    rightMin = sorted[++idx]
                    if(map[rightMin]!! > i) break
                }
            }

            if(stack == 2) continue
             count++
            //오른쪽보다 내가 작거나 같다 -> 내가 가장 작은 거임.
            // 또한 오른쪽 가장 작은걸 업데이트 해줘야함 현재 idx보다 큰걸로            
        }
        return count
    }
}