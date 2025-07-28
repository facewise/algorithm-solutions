import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().trim().toInt()
    val dp = Array(n + 1) { IntArray(3) }

    repeat(n) {
        val (r, g, b) = reader.readLine().trim().split(" ").map(String::toInt)
        dp[it + 1][0] = kotlin.math.min(dp[it][1], dp[it][2]) + r
        dp[it + 1][1] = kotlin.math.min(dp[it][0], dp[it][2]) + g
        dp[it + 1][2] = kotlin.math.min(dp[it][0], dp[it][1]) + b
    }

    writer.write("${kotlin.math.min(dp[n][0], kotlin.math.min(dp[n][1], dp[n][2]))}")
    writer.flush()
}
