import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val map = HashMap<String, Int>()
    br.readLine().toCharArray().forEach {
        with(map.getOrPut(it.uppercase()) { 0 }) {
            map[it.uppercase()] = this + 1
        }
    }
    val max = map.values.max()
    if (map.values.count { it == max } > 1) {
        bw.write("?")
    }
    else {
        bw.write(map.maxBy { it.value == max }.key)
    }

    bw.flush()
    bw.close()
}
