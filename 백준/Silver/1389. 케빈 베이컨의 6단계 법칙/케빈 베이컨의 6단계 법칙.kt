import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    class Tuple(var link: Boolean = false, var step: Int? = null) {
        override fun toString(): String {
            return "($link,$step)"
        }
    }

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val split = reader.readLine().split(" ").map(String::toInt)

    val map = Array(split[0] + 1) { Array(split[0] + 1) { Tuple() } }

    repeat(split[1]) {
        val edge = reader.readLine().split(" ").map(String::toInt)
        map[edge[0]][edge[1]].link = true
        map[edge[1]][edge[0]].link = true
    }

    val baconNumbers = IntArray(split[0] + 1)

    for (i in 1..split[0]) {
        val checked = BooleanArray(split[0] + 1)
        val queue = ArrayDeque<IntArray>()
        queue.offer(intArrayOf(i, 0))
        while (queue.isNotEmpty()) {
            val (node, depth) = queue.poll()
            if (checked[node]) {
                continue
            }
            checked[node] = true
            for (j in map[node].indices) {
                if (map[node][j].link && i != j) {
                    queue.offer(intArrayOf(j, depth + 1))
                    map[i][j].step = map[i][j].step ?: (depth + 1)
                    map[j][i].step = map[j][i].step ?: (depth + 1)
                }
            }
        }
    }

    map.forEachIndexed { i, node ->
        if (i == 0) return@forEachIndexed
        baconNumbers[i] = node.sumOf { it -> it.step ?: 0 }
    }

    val min = baconNumbers.drop(1).min()
    val answer = baconNumbers.indices.first { baconNumbers[it] == min }
    writer.write("$answer")
    writer.newLine()
    writer.flush()
}
