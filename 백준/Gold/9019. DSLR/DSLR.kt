import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().trim().toInt()
    repeat(t) {
        val (a, b) = br.readLine().trim().split(" ").map { it.toInt() }
        val queue = ArrayDeque<Pair<Int, String>>()
        val checked = BooleanArray(10000)
        queue.offer(a to "")
        while (queue.isNotEmpty()) {
            val (n, chars) = queue.poll()
            if (n == b) {
                bw.write(chars)
                bw.newLine()
                break
            }
            if (checked[n])
                continue
            checked[n] = true
            var doL = true
            var doR = true
            if (chars.endsWith("LL") || chars.endsWith("RRL")) {
                doL = false
            }
            if (chars.endsWith("RR") || chars.endsWith("LLR")) {
                doR = false
            }
            // D
            val d = (n shl 1) % 10000
            queue.offer(d to chars + 'D')

            // S
            val s = if (n == 0) 9999 else n - 1
            queue.offer(s to chars + 'S')

            if (doL) {
                val l = (n * 10 + n / 1000) % 10000
                queue.offer(l to chars + 'L')
            }
            if (doR) {
                val r = (n / 10 + n * 1000) % 10000
                queue.offer(r to chars + 'R')
            }
        }
    }
    bw.flush()
}
