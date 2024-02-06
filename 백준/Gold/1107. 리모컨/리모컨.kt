import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.min

var min = Int.MAX_VALUE
var targetChannel = 0
var available: Array<Int> = Array(0) { 0 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = br.readLine()?.trim() ?: return
    if (input == "100") {
        bw.write("0")
        bw.flush()
        return
    }
    if (input == "99" || input == "101") {
        bw.write("1")
        bw.flush()
        return
    }
    targetChannel = input.toInt()
    min = min(min, abs(targetChannel - 100))
    val n = br.readLine().trim().toInt()
    val broken = BooleanArray(10)
    if (n > 0) {
        br.readLine().trim().split(" ").forEach { broken[it.toInt()] = true }
    }
    available = broken.indices.filter { !broken[it] }.toTypedArray()
    dfs(0, 0, input.length + 1)
    bw.write("$min")
    bw.flush()
}

fun dfs(depth: Int, cur: Int, maxDepth: Int) {
    if (depth == maxDepth) {
        return
    }
    for (i in available) {
        val added = cur * 10 + i
        min = min(min, abs(targetChannel - added) + depth + 1)
        dfs(depth + 1, added, maxDepth)
    }
}
