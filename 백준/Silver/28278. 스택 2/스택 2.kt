import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val size = br.readLine()?.trim()?.toInt() ?: return
    val stack = Stack(size)

    repeat(size) {
        val line = br.readLine()?.trim()?.split(" ") ?: return@repeat
        when (line[0]) {
            "1" -> stack.push(line[1])
            "2" -> {
                bw.write(stack.pop())
                bw.newLine()
            }
            "3" -> {
                bw.write(stack.currentSize())
                bw.newLine()
            }
            "4" -> {
                bw.write(if (stack.isEmpty()) "1" else "0")
                bw.newLine()
            }
            "5" -> {
                bw.write(stack.peek())
                bw.newLine()
            }
        }
    }
    bw.flush()
}

class Stack(size: Int) {
    private val stack = IntArray(size)
    private var pointer = -1

    fun push(el: String) {
        stack[++pointer] = el.toInt()
    }

    fun pop(): String {
        if (isEmpty()) return "-1"
        return stack[pointer--].toString()
    }

    fun peek(): String {
        if (isEmpty()) return "-1"
        return stack[pointer].toString()
    }

    fun isEmpty() = pointer == -1

    fun currentSize() = (pointer + 1).toString()
}
