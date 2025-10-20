
private data class Location(val z: Int =0, val x: Int=0, val y: Int=0, val time: Int=0)

private fun setLoc(z: Int, x: Int, y: Int, time: Int = 0): Location = Location(z, x, y, time)
private val bw = System.`out`.bufferedWriter()
private val dx = listOf(1, 0, -1, 0, 0, 0)
private val dy = listOf(0, 1, 0, -1, 0, 0)
private val dz = listOf(0, 0, 0, 0, -1, 1)

private fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val st = readLine().split(" ").map { it.toInt() }

        val l = st[0]
        val r = st[1]
        val c = st[2]

        if (l == 0) break

        var startLoc = Location()
        var endLoc = Location()
        val queue = ArrayDeque<Location>()
        val visited = Array(l) { Array(r) { Array(c) { false } } }
        val building = Array(l) { Array(r) { Array(c) { "" } } }
        var success = false

        for (z in 0..<l) {
            // z층의 지도를 그린다
            for (x in 0..<r) {
                //x열의 길을 그린다.
                val line = readLine().chunked(1)
                for (y in 0..<c) {
                    //z층 x열 y번째 값을 받는다.
                    building[z][x][y] = line[y]
                    if (line[y] == "S") startLoc = setLoc(z, x, y,0)
                    else if (line[y] == "E") endLoc = setLoc(z, x, y)
                }
            }
            readLine()
        }

        queue.addLast(startLoc)
        visited[startLoc.z][startLoc.x][startLoc.y] = true

        while (!queue.isEmpty()) {
            val cur = queue.removeFirst()

            if (cur.x == endLoc.x && cur.y == endLoc.y && cur.z == endLoc.z) {
                bw.write("Escaped in ${cur.time} minute(s).\n")
                success = true
                break
            }

            for (i in 0..5) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]
                val nz = cur.z + dz[i]
                val time = cur.time

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || nz < 0 || nz >= l) continue
                if (building[nz][nx][ny] == "#") continue
                if (visited[nz][nx][ny]) continue

                visited[nz][nx][ny] = true
                queue.addLast(setLoc(nz, nx, ny, cur.time + 1))
            }
        }
        if (!success) bw.write("Trapped!\n")
    }

    bw.flush()
    bw.close()
}