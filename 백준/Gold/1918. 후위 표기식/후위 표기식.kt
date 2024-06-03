import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = br.readLine().trim().toCharArray()
    val stack = ArrayDeque<Char>(101)
    for (c in arr) {
        if (c in 'A'..'Z') {
            bw.append(c)
        } else if (c == ')') {
            var pop = stack.pop()
            while (pop != '(') {
                bw.append(pop)
                pop = stack.pop()
            }
        } else {
            while (hasToPop(c, stack)) {
                bw.append(stack.pop())
            }
            stack.push(c)
        }
    }
    flushStack(stack, bw)
    bw.flush()
}

fun flushStack(stack: ArrayDeque<Char>, bw: BufferedWriter) {
    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        if (pop == '(') {
            continue
        }
        bw.append(pop)
    }
}

fun hasToPop(op: Char, stack: ArrayDeque<Char>): Boolean {
    val top = stack.peek()
    return when (op) {
        '+', '-' -> return top == '*' || top == '/' || top == '+' || top == '-'
        '*', '/' -> return top == '*' || top == '/'
        else -> false
    }
}
