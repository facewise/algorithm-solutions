import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = br.readLine()?.trim()?.split(" ") ?: return
    val checked = BooleanArray(input[0].toInt())

    dfs(bw, IntArray(input[1].toInt()), checked, input[1].toInt(), 0)
}

fun dfs(bw: BufferedWriter, array: IntArray, checked: BooleanArray, maxDepth: Int, depth: Int) {
    if (depth == maxDepth) {
        bw.write(array.joinToString(" "))
        bw.newLine()
        bw.flush()
        return
    }

    for (i in checked.indices) {
        if (!checked[i]) {
            checked[i] = true
            array[depth] = i + 1
            dfs(bw, array, checked,  maxDepth, depth + 1)
            checked[i] = false
        }
    }

}
