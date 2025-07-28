import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var white = 0
var blue = 0
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().trim().toInt()
    val map = Array(n) { BooleanArray(n) }

    repeat(n) {
        reader.readLine().trim().split(" ").forEachIndexed { index, s ->
            if (s == "1") {
                map[it][index] = true
            }
        }
    }

    dfs(map, 0, n, 0, n)

    writer.write("$white\n$blue\n")
    writer.flush()
}

fun dfs(map: Array<BooleanArray>, rowStart: Int, rowEnd: Int, colStart: Int, colEnd: Int) {
    val isBlue = map[rowStart][colStart]
    for (i in rowStart..<rowEnd) {
        for (j in colStart..<colEnd) {
            if (map[i][j] != isBlue) {
                val rowHalf = (rowStart + rowEnd) / 2
                val colHalf = (colStart + colEnd) / 2
                dfs(map, rowStart, rowHalf, colStart, colHalf)
                dfs(map, rowHalf, rowEnd, colStart, colHalf)
                dfs(map, rowStart, rowHalf, colHalf, colEnd)
                dfs(map, rowHalf, rowEnd, colHalf, colEnd)
                return
            }
        }
    }
    if (isBlue) blue++ else white++
}
