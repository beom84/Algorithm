

var R = 0
var C = 0
var M = 0
val sharkArr = arrayListOf<Shark>()
val arr = Array(100){IntArray(100){ -1 } }  //-1은 빈 공간 (현재 상위의 위치)
val nextArr = Array(100){IntArray(100){ -1 } }// -1은 빈 공간(이동 후 상어의 위치)
var answer = 0

var personY = -1 //낚시왕의 위치

data class Shark(
    val s : Int,    //속력
    var d : Int,    //방향
    val z : Int     //크기
)

fun movePerson(){   // 1.낚시왕이 오른쪽으로 한 칸 이동한다.
    personY++
    return
}

fun catchShark(){ // 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 가장 가까운 상어를 잡는다
    for(i in 0 until R){
        if(arr[i][personY] != -1){

            val shark = sharkArr[arr[i][personY]]   //발견된 상어
            answer += shark.z   //상어의 크기만큼 증가
            arr[i][personY] = -1    //상어가 존재했던 칸은 -1로

            break
        }
    }
}

fun moveShark(){    // 3.상어가 이동한다 and 상어가 이동을 마치고 한 칸에 두 마리 이상 존재하면 가장 큰 상어만 남긴다
    for(i in 0 until R){
        for(j in 0 until C){
            nextArr[i][j] = -1
        }
    }

    for(i in 0 until R){
        for(j in 0 until C){

            if(arr[i][j] != -1){    //상어가 발견된다면
                val shark = sharkArr[arr[i][j]] //발견된 상어

                //상어가 이동할 위치
                var nextX = i
                var nextY = j

                for(k in 0 until shark.s) {
                    when (shark.d) {
                        1 -> {  //위
                            if(--nextX < 0) {
                                nextX  = 1
                                shark.d = 2
                            }
                        }
                        2 -> {  //아래
                            if(++nextX >= R) {
                                nextX = R - 2
                                shark.d = 1
                            }
                        }
                        3 -> {  //오른쪽
                            if(++nextY >= C) {
                                nextY = C - 2
                                shark.d = 4
                            }
                        }
                        4 -> { //왼쪽
                            if(--nextY < 0) {
                                nextY = 1
                                shark.d = 3
                            }
                        }
                    }
                }


                //이동한 위치에 이미 상어가 존재한다면
                if(nextArr[nextX][nextY] != -1){
                    if(sharkArr[nextArr[nextX][nextY]].z < shark.z){
                        nextArr[nextX][nextY] = arr[i][j]
                        arr[i][j] = -1
                    }
                }
                else {  //이동한 위치에 상어가 존재하지 않는다면
                    nextArr[nextX][nextY] = arr[i][j]
                    arr[i][j] = -1
                }
            }
        }
    }

    for(i in 0 until R){	//이동 후의 상어들의 위치들을 현재 상어의 위치로 업데이트
        for(j in 0 until C){
            arr[i][j] = nextArr[i][j]
        }
    }

}

fun main(){
    readln().split(' ').map{it.toInt()}
        .forEachIndexed { idx, v ->
            if(idx == 0) R = v
            else if(idx == 1) C = v
            else M = v
        }

    for(i in 0 until M){
        val list = readln().split(' ').map{it.toInt()}

        val (x,y) = Pair(list[0] - 1, list[1] - 1)
        arr[x][y] =  i
        val shark = Shark(list[2], list[3], list[4])
        sharkArr.add(shark)
    }


    for(i in 0 until C){
        movePerson()
        catchShark()
        moveShark()

    }


    print(answer)
}