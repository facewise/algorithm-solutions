import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine()?.trim()?.toInt() ?: return
    if (n == 1) bw.write("666")
    if (n in 2..6) bw.write("${n - 1}666")
    if (n > 6) {
        var i = 6
        var start = 6660L
        while (i < n) {
            for (a in start..Long.MAX_VALUE) {
                if (a.toString().contains("666")) {
                    i++
                    start = a + 1
                    break
                }
            }
        }
        bw.write((start - 1).toString())
    }

    bw.flush()
}
