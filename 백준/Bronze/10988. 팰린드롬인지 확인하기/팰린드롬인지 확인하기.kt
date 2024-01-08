import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val charArray = br.readLine().toCharArray()
    var ans = 1
    run loop@{
        charArray.forEachIndexed { i, c ->
            if (i + 1 > charArray.size / 2) return@loop
            if (charArray[charArray.size - 1 - i] != c) {
                ans = 0
                return@loop
            }
        }
    }
    bw.write("$ans")
    bw.flush()
    bw.close()
    br.close()
}