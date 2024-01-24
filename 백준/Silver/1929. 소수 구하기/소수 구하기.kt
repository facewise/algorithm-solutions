import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val split = br.readLine()?.trim()?.split(" ")?.map { it.toInt() }?.toIntArray() ?: return

    val arr = BooleanArray(1_000_001)
    for (i in 2..split[1]) {
        if (arr[i])
            continue
        if (i >= split[0]) {
            bw.append(i.toString())
            bw.newLine()
        }
        for (j in 2 * i..split[1] step i) {
            arr[j] = true
        }
    }

    bw.flush()
}
