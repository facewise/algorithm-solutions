import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine()?.trim()?.toInt() ?: return
    val dp = Array(41) { IntArray(2) }
    dp[0] = intArrayOf(1, 0)
    dp[1] = intArrayOf(0, 1)
    repeat(t) {
        val n = br.readLine()?.trim()?.toInt() ?: return
        fib(n, dp)
        bw.write("${dp[n][0]} ${dp[n][1]}")
        bw.newLine()
    }
    bw.flush()
}

fun fib(n: Int, dp: Array<IntArray>): IntArray {
    if (dp[n][0] + dp[n][1] != 0) {
        return dp[n]
    }
    val first = fib(n - 1, dp)
    val second = fib(n - 2, dp)
    dp[n] = intArrayOf(first[0] + second[0], first[1] + second[1])
    return dp[n]
}
