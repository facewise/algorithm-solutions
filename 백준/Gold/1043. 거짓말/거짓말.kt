import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque

/**
 * knower 1,2,3,4
 * 1,5
 * 2,6
 * 7
 * 8
 * 7,8
 * 9
 * 10
 * 3,10
 * 4
 *
 * 초기 knower 포함 여부로 정렬
 *
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    fun link(graph: Array<BooleanArray>, array: Set<Int>) {
        for (i in array) {
            for (j in array) {
                if (graph[i][j] || graph[j][i]) continue
                graph[i][j] = true
                graph[j][i] = true
            }
        }
    }

    val (n, m) = reader.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return

    val secondLine = reader.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return
    if (secondLine.size == 1) {
        writer.write("$m\n")
    } else {
        val knowers = BooleanArray(n + 1)
        val queue = ArrayDeque<Int>()
        for (i in 1..<secondLine.size) {
            queue.offer(secondLine[i])
        }
        val graph = Array(n + 1) { BooleanArray(n + 1) }
        val parties = Array(m) { setOf<Int>() }
        repeat(m) {
            val party = reader.readLine()?.trim()?.split(" ")?.drop(1)?.map(String::toInt)?.toSet() ?: return
            parties[it] = party
            link(graph, party)
        }
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            if (knowers[poll]) continue
            knowers[poll] = true
            for (i in graph[poll].indices) {
                if (graph[poll][i]) {
                    queue.offer(i)
                }
            }
        }
        val answer = parties.count { set ->
            set.none { knowers[it] }
        }
        writer.write("$answer\n")
    }

    writer.flush()
}
