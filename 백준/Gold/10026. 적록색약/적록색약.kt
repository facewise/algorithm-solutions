import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

lateinit var arr: Array<CharArray>
lateinit var checked: Array<BooleanArray>
val d = arrayOf(intArrayOf(0, 1, 0, -1), intArrayOf(1, 0, -1, 0))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    arr = Array(n) { charArrayOf() }
    checked = Array(n) { BooleanArray(n) }

    repeat(n) {
        arr[it] = br.readLine().toCharArray()
    }

    var a = 0
    var b = 0

    for (i in 0..<n) {
        for (j in 0..<n) {
            if (!checked[i][j]) {
                bfs(i, j)
                a++
            }
        }
    }
    bw.write("$a ")
    arr.forEach {
        for (i in it.indices) {
            if (it[i] == 'G')
                it[i] = 'R'
        }
    }
    checked = Array(n) { BooleanArray(n) }
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (!checked[i][j]) {
                bfs(i, j)
                b++
            }
        }
    }
    bw.write("$b")
    bw.flush()
}

fun bfs(r: Int, c: Int) {
    val queue = ArrayDeque<IntArray>()
    val color = arr[r][c]
    queue.offer(intArrayOf(r, c))
    while (queue.isNotEmpty()) {
        val poll = queue.poll()
        for (i in 0..3) {
            try {
                val nr = poll[0] + d[0][i]
                val nc = poll[1] + d[1][i]
                if (checked[nr][nc])
                    continue
                if (arr[nr][nc] == color) {
                    checked[nr][nc] = true
                    queue.offer(intArrayOf(nr, nc))
                }
            } catch (_: Exception) {
            }
        }
    }
}
