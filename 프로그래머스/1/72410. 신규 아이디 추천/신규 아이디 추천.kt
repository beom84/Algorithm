class Solution {
fun solution(new_id: String): String {
    val regex = Regex("[^a-z0-9._-]")

    var newId = regex.replace(new_id.lowercase(), "")
    while (newId.contains(".."))
        newId = newId.replace("..", ".")
    if (newId.startsWith(".")) newId = newId.substring(1, newId.lastIndex + 1)
    if (newId.endsWith(".")) newId = newId.substring(0, newId.lastIndex )
    if (newId.isEmpty()) newId += "a"
    if (newId.length > 15) newId = newId.substring(0, 15)
    if (newId.endsWith(".")) newId = newId.substring(0, newId.lastIndex )
    if (newId.length < 3) for (i in newId.length..2) newId += newId[newId.lastIndex]
    return newId
    }
}