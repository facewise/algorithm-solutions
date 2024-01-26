import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val size = br.readLine()?.trim()?.toInt() ?: return

    val stack = Stack(size)
    val list = Array(size + 1) { ArrayList<Int>() }
    val parent = IntArray(size + 1)

    repeat(size - 1) {
        val split = br.readLine()?.trim()?.split(" ") ?: return
        val n = split[0].toInt()
        val m = split[1].toInt()
        list[n].add(m)
        list[m].add(n)
    }

    stack.push(1)
    while (stack.isNotEmpty()) {
        val n = stack.pop()
        for (i in list[n]) {
            if (parent[i] != 0)
                continue
            stack.push(i)
            parent[i] = n
        }
    }

    for (i in 2..size) {
        bw.write(parent[i].toString())
        bw.newLine()
    }
    bw.flush()
}

class Stack(size: Int) {
    val array = IntArray(size)
    var p = -1

    fun push(el: Int) {
        array[++p] = el
    }

    fun pop() = array[p--]

    fun isNotEmpty(): Boolean = p != -1
}
