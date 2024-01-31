import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine()?.trim()?.toInt() ?: return
    repeat(t) {
        val input = br.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return
        // 밭
        val field = Array(input[0]) { BooleanArray(input[1]) }
        // 탐색 시 사용
        val checked = Array(input[0]) { BooleanArray(input[1]) }
        repeat(input[2]) {
            // 배추 위치
            val cab = br.readLine()?.trim()?.split(" ")?.map(String::toInt) ?: return
            field[cab[0]][cab[1]] = true
        }
        var sum = 0
        val queue = ArrayDeque<IntArray>()
        // 밭을 순회하면서 배추가 심어진 곳이면서 방문한 적이 없으면 bfs 탐색 시작
        for (i in field.indices) {
            for (j in field[0].indices) {
                if (field[i][j] && !checked[i][j]) {
                    // 시작점
                    queue.push(intArrayOf(i, j))
                    while (queue.isNotEmpty()) {
                        val coordinate = queue.poll()
                        // 이미 방문했으면 skip
                        val x = coordinate[0]
                        val y = coordinate[1]
                        try {
                            if (checked[x][y]) continue
                            // 배추가 없으면 skip
                            if (!field[x][y]) continue
                            checked[x][y] = true
                            // 상하좌우 queue에 push
                            queue.push(intArrayOf(x - 1, y))
                            queue.push(intArrayOf(x + 1, y))
                            queue.push(intArrayOf(x, y - 1))
                            queue.push(intArrayOf(x, y + 1))
                        } catch (_: IndexOutOfBoundsException) {
                            // index 초과 시 무시
                        }
                    }
                    sum++
                }
            }
        }
        bw.write("$sum")
        bw.newLine()
    }
    bw.flush()
}
