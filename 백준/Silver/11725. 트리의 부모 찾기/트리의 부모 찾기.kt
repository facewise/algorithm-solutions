import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val size = br.readLine()?.trim()?.toInt() ?: return

    val queue = Queue(size)
    val list = Array(size + 1) { ArrayList<Int>() }
    val parent = IntArray(size + 1)

    repeat(size - 1) {
        val split = br.readLine()?.trim()?.split(" ") ?: return
        val n = split[0].toInt()
        val m = split[1].toInt()
        list[n].add(m)
        list[m].add(n)
    }

    queue.push(1)
    while (queue.isNotEmpty()) {
        val n = queue.poll()
        for (i in list[n]) {
            if (parent[i] != 0)
                continue
            queue.push(i)
            parent[i] = n
        }
    }

    for (i in 2..size) {
        bw.write(parent[i].toString())
        bw.newLine()
    }
    bw.flush()
}

class Queue(size: Int) {
    private val array = IntArray(size)
    private var front = 0
    private var rear = 0

    fun push(el: Int) {
        if (rear + 1 == array.size) {
            rear = -1
        }
        array[++rear] = el
    }

    fun poll(): Int {
        if (front + 1 == array.size) {
            front = -1
        }
        return array[++front]
    }

    fun isNotEmpty(): Boolean = front != rear
}
