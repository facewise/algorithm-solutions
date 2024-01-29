import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val split = br.readLine()?.trim()?.split(" ") ?: return
    val arr = br.readLine().trim()
        .split(" ")
        .map(String::toInt)
        .toTypedArray()

    val window = split[1].toInt()
    var sum = 0
    (0..<window).forEach { sum += arr[it] }
    var max = sum
    (window..<arr.size).forEach {
        sum -= arr[it - window]
        sum += arr[it]
        if (sum > max) max = sum
    }
    bw.write(max.toString())
    bw.flush()
}
