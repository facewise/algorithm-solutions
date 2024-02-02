import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = br.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return

    val box = Array(input[1]) { Array(input[0]) { IntArray(2) } }

    val queue = ArrayDeque<Pair<Int, Int>>()

    repeat(input[1]) { i ->
        br.readLine()?.trim()?.split(" ")?.forEachIndexed { idx, it ->
            val n = it.toInt()
            box[i][idx][0] = n
            if (n == 1) {
                queue.offer(i to idx)
            }
        }
    }

    // 모두 익어있을 경우
    if (queue.size == input[0] * input[1]) {
        bw.write("0")
        bw.flush()
        return
    }

    while (queue.isNotEmpty()) {
        val poll = queue.poll()
        val currentDay = box[poll.first][poll.second][1]
        checkTomato(box, poll.first - 1, poll.second, queue, currentDay)
        checkTomato(box, poll.first + 1, poll.second, queue, currentDay)
        checkTomato(box, poll.first, poll.second - 1, queue, currentDay)
        checkTomato(box, poll.first, poll.second + 1, queue, currentDay)
    }

    var max = 0
    for (i in box.indices) {
        for (j in box[0].indices) {
            // 안 익은 토마토 발견
            if (box[i][j][0] == 0) {
                bw.write("-1")
                bw.flush()
                return
            }
            max = max(box[i][j][1], max)
        }
    }
    bw.write("$max")
    bw.flush()
}

fun checkTomato(box: Array<Array<IntArray>>, row: Int, col: Int, queue: ArrayDeque<Pair<Int, Int>>, currentDay: Int) {
    try {
        // 안 익은 토마토였을 때만 익게 만들고 queue에 집어넣기
        if (box[row][col][0] == 0) {
            box[row][col][0] = 1
            box[row][col][1] = currentDay + 1
            queue.offer(row to col)
        }
    } catch (_: IndexOutOfBoundsException) {

    }
}
