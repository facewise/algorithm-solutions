import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine()?.trim()?.toInt() ?: return
    val arr = IntArray(n + 1)
    var rear = 0

    repeat(n) {
        val op = br.readLine().trim()
        if (op == "0") {
            if (rear == 0) bw.write("0")
            else {
                bw.write(arr[1].toString())
                arr[1] = arr[rear]
                arr[rear] = 0
                rear--
                var childIndex = 2
                while (childIndex <= rear) {
                    if (arr[childIndex + 1] != 0) {
                        if (arr[childIndex + 1] < arr[childIndex])
                            childIndex++
                    }
                    val parentIndex = childIndex / 2
                    if (arr[childIndex / 2] > arr[childIndex]) {
                        val tmp = arr[parentIndex]
                        arr[parentIndex] = arr[childIndex]
                        arr[childIndex] = tmp
                    } else {
                        break
                    }
                    childIndex *= 2
                }
            }
            bw.newLine()
        } else {
            arr[++rear] = op.toInt()
            var i = rear
            while (i > 1) {
                if (arr[i] < arr[i / 2]) {
                    val tmp = arr[i / 2]
                    arr[i / 2] = arr[i]
                    arr[i] = tmp
                } else {
                    break
                }
                i /= 2
            }
        }
    }
    bw.flush()
}
