import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    br.readLine()
    val split = br.readLine()?.trim()?.split(" ")?.map { it.toInt() } ?: return
    val sorted = split.distinct().toIntArray().sorted()
    for (i in split.indices) {
        bw.write(sorted.binarySearch(split[i]).toString())
        bw.write(' '.code)
    }
    bw.flush()
}
