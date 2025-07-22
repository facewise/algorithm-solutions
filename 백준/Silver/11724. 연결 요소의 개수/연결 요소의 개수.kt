import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var answer = 0

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = reader.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return
    val graph = Array(n + 1) { BooleanArray(n + 1) }

    repeat(m) {
        val (r, c) = reader.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return
        graph[r][c] = true
        graph[c][r] = true
    }

    val checked = BooleanArray(n + 1)
    for (i in 1..n) {
        if (checked[i]) continue
        dfs(i, graph, checked)
        answer++
    }

    writer.write("$answer\n")
    writer.flush()
}

fun dfs(edge: Int, graph: Array<BooleanArray>, checked: BooleanArray) {
    if (checked[edge]) return
    checked[edge] = true
    for (i in graph[edge].indices) {
        if (graph[edge][i]) dfs(i, graph, checked)
    }
}
