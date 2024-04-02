import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val moves = IntArray(101)
val checked = BooleanArray(101)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    repeat(n + m) {
        val (a, b) = br.readLine().trim().split(" ").map(String::toInt)
        moves[a] = b
    }
    val queue = ArrayDeque<IntArray>()
    queue.offer(intArrayOf(1, 0))
    while (queue.isNotEmpty()) {
        val (current, dices) = queue.poll()
        if (current == 100) {
            bw.write("$dices")
            break
        }
        val move = moves[current]
        if (move != 0) {
            queue.push(intArrayOf(move, dices))
            continue
        }
        for (d in 1..6) {
            val next = current + d
            if (next > 100)
                break
            if (checked[next])
                continue
            checked[next] = true
            queue.offer(intArrayOf(next, dices + 1))
        }
    }
    bw.flush()
}
