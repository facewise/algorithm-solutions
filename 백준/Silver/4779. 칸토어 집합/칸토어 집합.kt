import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val line = br.readLine()?.trim()
        if (line.isNullOrBlank()) break
        val n = line.toInt()
        if (n == 0) {
            println("-")
            continue
        }
        var size = 1
        repeat(n) {
            size *= 3
        }
        println(cantor(CharArray(size) { '-' }))
    }
}

fun cantor(input: CharArray): CharArray {
    if (input.size == 1 && input[0] == '-') {
        return input
    }
    val divided = input.size / 3

    return cantor(input.sliceArray(0..<divided)) + CharArray(divided) { ' ' } + cantor(input.sliceArray(divided * 2..<input.size))
}
