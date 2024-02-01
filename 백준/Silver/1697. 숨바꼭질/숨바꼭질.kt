import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = br.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return

    val map = HashMap<Int, Unit>()
    val queue = ArrayList<Pair<Int, Int>>()

    val n = input[1]

    queue.add(input[0] to 0)
    while (queue.isNotEmpty()) {
        val poll = queue[0]
        val cur = poll.first
        if (cur == n) {
            bw.write("${poll.second}")
            break
        }
        queue.removeFirst()
        if (map.containsKey(cur))
            continue
        map[cur] = Unit
        val level = poll.second + 1
        if (cur > 0) {
            queue.add(cur - 1 to level)
        }
        queue.add(cur + 1 to level)
        if (cur * 2 < n * 2) {
            queue.add(cur * 2 to level)
        }
    }

    bw.flush()
}
