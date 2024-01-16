import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val cache = Array(21) { Array(21) { IntArray(21) } }
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val line = br.readLine().trim()
        if (line == "-1 -1 -1") break
        if (line.isNotEmpty()) {
            val split = line.split(" ")
            if (split.size == 3) {
                println(("w(${split[0]}, ${split[1]}, ${split[2]}) = ${w(split[0].toInt(),split[1].toInt(),split[2].toInt(),cache)}")
                )
            }
        }
    }
}

fun w(a: Int, b: Int, c: Int, cache: Array<Array<IntArray>>): Int {
    if (a <= 0 || b <= 0 || c <= 0) return 1
    if (a > 20 || b > 20 || c > 20) return w(20, 20, 20, cache)

    if (cache[a][b][c] == 0) {
        if (a < b && b < c) {
            cache[a][b][c] = w(a, b, c - 1, cache) + w(a, b - 1, c - 1, cache) - w(a, b - 1, c, cache)
            return cache[a][b][c]
        } else {
            cache[a][b][c] = w(a - 1, b, c, cache) + w(a - 1, b - 1, c, cache) + w(a - 1, b, c - 1, cache) - w(a - 1,b - 1,c - 1,cache)
            return cache[a][b][c]
        }
    } else {
        return cache[a][b][c]
    }
}
