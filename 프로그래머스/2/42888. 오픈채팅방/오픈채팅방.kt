class Solution {
    fun solution(record: Array<String>): Array<String> {
    val inOutList = mutableListOf<Pair<String,String>>()
    val nickNameMap = mutableMapOf<String, String>()

    record.forEach { word ->
        val (state, uid) = word.split(" ")
        when (state) {
            "Leave" ->{
                inOutList.add(Pair(uid,"님이 나갔습니다."))
            }
            "Enter" -> {
                nickNameMap[uid] = word.split(" ")[2]
                inOutList.add(Pair(uid,"님이 들어왔습니다."))
            }
            "Change" -> {
                nickNameMap[uid] = word.split(" ")[2]
            }
        }
    }
   return inOutList.map { (uid,message)->
        "${nickNameMap[uid]}$message"
    }.toTypedArray()
}
}