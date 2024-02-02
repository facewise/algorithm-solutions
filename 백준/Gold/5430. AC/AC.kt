import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine()?.trim()?.toInt() ?: return

    repeat(t) {
        val inst = br.readLine().toCharArray()
        val n = br.readLine().toInt()
        val queue = ArrayDeque<String>()
        var reversed = false
        if (n > 0) {
            br.readLine().removeSurrounding("[", "]").split(",").forEach(queue::offer)
        } else {
            br.readLine()
        }
        inst.forEach {
            if (it == 'R')
                reversed = !reversed
            else {
                if (queue.isEmpty()) {
                    bw.write("error")
                    bw.newLine()
                    return@repeat
                } else {
                    if (reversed) {
                        queue.pollLast()
                    } else {
                        queue.pollFirst()
                    }
                }
            }
        }
        if (reversed) {
            bw.write(queue.reversed().joinToString(",", "[", "]"))
        } else {
            bw.write(queue.joinToString(",", "[", "]"))
        }
        bw.newLine()
    }

    bw.flush()
}
