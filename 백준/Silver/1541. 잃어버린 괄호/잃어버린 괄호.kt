import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val line = reader.readLine()?.trim() ?: return
    var answer = 0
    var currentAdd = true
    var num = 0
    for (c in line) {
        if (c.isDigit()) {
            num = num * 10 + (c - '0')
        } else {
            if (currentAdd) {
                answer += num
                num = 0
                if (c == '-') {
                    currentAdd = false
                }
            } else {
                answer -= num
                num = 0
            }
        }
    }
    if (currentAdd) {
        answer += num
    } else {
        answer -= num
    }
    writer.write("$answer")
    writer.flush()
}
