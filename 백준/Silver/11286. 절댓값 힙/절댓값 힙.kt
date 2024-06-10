import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().trim().toInt()
    val heap = AbsHeap(n)
    repeat(n) {
        val op = br.readLine().trim().toInt()
        if (op == 0) {
            bw.write("${heap.pop()}")
            bw.newLine()
        } else {
            heap.push(op)
        }
    }

    bw.flush()
}

class AbsHeap(n: Int) {
    val arr = IntArray(n)
    var len = 0

    fun push(x: Int) {
        arr[len++] = x
        var start = len - 1
        while (start > 0) {
            val parent = (start - 1) ushr 1
            val parentAbs = abs(arr[parent])
            val abs = abs(arr[start])
            if (abs < parentAbs) {
                val tmp = arr[parent]
                arr[parent] = arr[start]
                arr[start] = tmp
            } else if (abs == parentAbs) {
                val parentEl = arr[parent]
                val el = arr[start]
                if (el < parentEl) {
                    arr[parent] = el
                    arr[start] = parentEl
                } else {
                    return
                }
            } else {
                return
            }
            start = parent
        }
    }

    fun pop(): Int {
        if (len == 0)
            return 0
        val ret = arr[0]
        arr[0] = arr[len - 1]
        arr[--len] = 0
        var start = 0
        while (arr[start] != 0) {
            val leftChild = (start shl 1) + 1
            val rightChild = leftChild + 1
            if (leftChild >= len) {
                return ret
            }
            val leftAbs = abs(arr[leftChild])
            val rightAbs = abs(arr[rightChild])
            val isLeft = (rightAbs == 0) || (leftAbs < rightAbs) || (leftAbs == rightAbs && arr[leftChild] < arr[rightChild])
            val min = if (isLeft) leftAbs else rightAbs
            val childIndex = if (isLeft) leftChild else rightChild
            val abs = abs(arr[start])

            if (abs < min)
                return ret

            if (abs == min) {
                if (arr[start] < arr[childIndex])
                    return ret
            }

            val tmp = arr[start]
            arr[start] = arr[childIndex]
            arr[childIndex] = tmp
            start = childIndex
        }

        return ret
    }
}
