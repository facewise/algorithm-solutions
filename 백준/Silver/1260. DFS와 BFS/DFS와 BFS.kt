import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque

/**
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * map:
 * [false, true, true, true]
 * [true, false, false, true]
 * [true, false, false, true]
 * [true, true, true, false]
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val split = reader.readLine().split(" ").map(String::toInt)

    val map = Array(split[0] + 1) { BooleanArray(split[0] + 1) }

    repeat(split[1]) {
        val edge = reader.readLine().split(" ").map(String::toInt)
        map[edge[0]][edge[1]] = true
        map[edge[1]][edge[0]] = true
    }

    var checked = BooleanArray(split[0] + 1)

    dfs(split[2], map, checked, writer)
    writer.flush()
    writer.newLine()

    checked = BooleanArray(split[0] + 1)

    val queue = ArrayDeque<Int>()
    queue.offer(split[2])
    bfs(queue, checked, map, writer)

    writer.flush()
}

fun bfs(queue: ArrayDeque<Int>, checked: BooleanArray, map: Array<BooleanArray>, writer: BufferedWriter) {
    while (queue.isNotEmpty()) {
        val poll = queue.poll()
        if (checked[poll]) {
            continue
        }
        checked[poll] = true
        writer.write("$poll ")
        for (i in map.indices) {
            if (map[poll][i]) {
                queue.offer(i)
            }
        }
    }
}

fun dfs(start: Int, map: Array<BooleanArray>, checked: BooleanArray, writer: BufferedWriter) {
    if (checked[start]) {
        return
    }
    writer.write("$start ")
    checked[start] = true

    for (i in map.indices) {
        if (map[start][i]) {
            dfs(i, map, checked, writer)
        }
    }
}
