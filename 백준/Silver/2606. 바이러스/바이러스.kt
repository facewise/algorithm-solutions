import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine()?.trim()?.toInt() ?: return
    val m = reader.readLine()?.trim()?.toInt() ?: return
    val graph = Array(n + 1) { BooleanArray(n + 1) }

    repeat(m) {
        val (e1, e2) = reader.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return
        graph[e1][e2] = true
        graph[e2][e1] = true
    }

    val checked = BooleanArray(n + 1)

    fun dfs(node: Int) {
        if (checked[node]) return
        checked[node] = true
        graph[node].forEachIndexed { index, b -> if (b) dfs(index) }
    }

    dfs(1)

    writer.write("${checked.count{ it -> it } - 1}")
    writer.flush()
}
