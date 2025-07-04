import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * IntArray = [시작시간, 종료시간]
 */
fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine()?.trim()?.toInt() ?: return
    val array = Array(n) { IntArray(0) }

    repeat(n) {
        array[it] = reader.readLine().trim().split(" ").map(String::toInt).toIntArray()
    }

    array.sortWith { o1, o2 -> 
        val compare = o1[1] - o2[1]
        if (compare == 0) o1[0] - o2[0] else compare
    }

    var count = 0
    var currentFinish = 0

    for (meeting in array) {
        if (meeting[0] >= currentFinish) {
            currentFinish = meeting[1]
            count++
        }
    }

    writer.write("$count\n")
    writer.flush()
}
