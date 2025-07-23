import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var (n, r, c) = reader.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return

    var answer = 0
    var size = 1.shl(n)

    while (size > 1) {
        val half = size.shr(1)
        val adder = half * half
        if (r >= half) {
            answer += adder.shl(1)
            r -= half
        }
        if (c >= half) {
            answer += adder
            c -= half
        }
        size = 1.shl(--n)
    }

    writer.write("$answer\n")
    writer.flush()
}
