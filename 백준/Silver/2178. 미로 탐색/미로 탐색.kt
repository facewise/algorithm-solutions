import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = reader.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return
    val empty = IntArray(0)
    val map = Array(n) { empty }
    val checked = Array(n) { BooleanArray(m) }

    val rowDiff = intArrayOf(0, 1, 0, -1)
    val colDiff = intArrayOf(1, 0, -1, 0)

    repeat(n) {
        map[it] = reader.readLine()?.trim()?.toCharArray()?.map(Char::digitToInt)?.toIntArray() ?: return
    }
    val queue = ArrayDeque<IntArray>()
    queue.offer(intArrayOf(0, 0, 1))

    while (queue.isNotEmpty()) {
        val (row, col, steps) = queue.poll()
        if (row == n - 1 && col == m - 1) {
            writer.write("$steps\n")
            break
        }
        if (row !in 0 until n || col !in 0 until m || checked[row][col] || map[row][col] == 0) continue
        checked[row][col] = true
        for (i in 0..3) {
            val nextRow = row + rowDiff[i]
            val nextCol = col + colDiff[i]
            queue.offer(intArrayOf(nextRow, nextCol, steps + 1))
        }
    }

    writer.flush()
}
