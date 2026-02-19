/*
 입력
 gems
 - 배열의 크기는 1 이상 100,000 이하입니다.
 - gems 배열의 각 원소는 진열대에 나열된 보석을 나타냅니다.
 - gems 배열에는 1번 진열대부터 진열대 번호 순서대로 보석이름이 차례대로 저장되어 있습니다.
 - gems 배열의 각 원소는 길이가 1 이상 10 이하인 알파벳 대문자로만 구성된 문자열입니다.

 문제 정의
 특정범위의 보석을 모두 구매하지만 아래의 조건을 달성한다.
 종류가 있고 보석이 있네
 모든 보석을 하나 이상 포함하는 가장 짧은 구간을 찾아서 return 하시오
 
 알고리즘
 - 슬라이딩 윈도우
    - start end를 가지고 특정 범위를 만족할떄까지 늘리고 줄인다. 가장 적을떄 멈춘다.
 
 자료구조
 - 보석의 포함 여부를 확인하는 set
 - start end를 포함하는 result 
 
*/
class Solution {
    fun solution(gems: Array<String>): IntArray {
        var answer = intArrayOf()
        var minLength = Int.MAX_VALUE
        var start = 0
        var end = 0
        val jewelySet = gems.toSet()
        val myJewely = HashMap<String,Int>()
        
        myJewely[gems[0]] = 1
        var result = IntArray(2)
        if(jewelySet.size ==1) return intArrayOf(1,1)
        
        while(end <= gems.size-1 && end>=start){
            if(myJewely.size < jewelySet.size) {
                end++
                if(end>gems.lastIndex) break
                myJewely[gems[end]] = myJewely.getOrDefault(gems[end],0) + 1
                //있다면 더하고 없다면 빼기
            }else{
                myJewely[gems[start]] = myJewely.getOrDefault(gems[start],0) - 1
                if(myJewely[gems[start]]!! <= 0) myJewely.remove(gems[start])
                start++
            }
            
            if(myJewely.size == jewelySet.size){
                if(end - start < minLength){
                    minLength = end - start
                result[0] = start + 1
                result[1] = end + 1 
                }
            }
            
        }
        return result
    }
}