import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var mod = 1L

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (a, b, c) = br.readLine().trim().split(" ").map(String::toInt)
    val cLong = c.toLong()
    mod = a.mod(cLong)
    val ans = dfs(b, cLong)
    bw.write("$ans")
    bw.flush()
}

fun dfs(e: Int, divider: Long): Long {
    if (e == 1)
        return mod
    val half = dfs(e / 2, divider)
    val r = (half * half).mod(divider)
    if (e.mod(2) == 1) {
        return (r * mod).mod(divider)
    }
    return r
}
