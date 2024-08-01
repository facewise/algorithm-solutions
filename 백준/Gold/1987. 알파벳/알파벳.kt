import kotlin.math.max

var max = Int.MIN_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (r, c) = br.readLine().trim().split(" ").map(String::toInt)

    val map = Array(r) { CharArray(c) }

    repeat(r) {
        map[it] = br.readLine().trim().toCharArray()
    }
    val checked = BooleanArray(26)

    dfs(map, 0, 0, checked)

    bw.write("$max")
    bw.flush()
}

fun dfs(map: Array<CharArray>, r: Int, c: Int, checked: BooleanArray) {
    if (r < 0 || c < 0 || r >= map.size || c >= map[0].size
        || checked[map[r][c].code - 65]
    ) {
        var sum = 0
        for (b in checked) {
            if (b) sum++
        }
        max = max(max, sum)
        return
    }
    checked[map[r][c].code - 65] = true
    dfs(map, r + 1, c, checked)
    dfs(map, r - 1, c, checked)
    dfs(map, r, c + 1, checked)
    dfs(map, r, c - 1, checked)
    checked[map[r][c].code - 65] = false
}
