import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine()?.trim()?.toInt() ?: return

    val dp = Array(8) { Array(0) { BooleanArray(0) } }
    dp[1] = Array(3) {
        if (it != 1) BooleanArray(3) { true }
        else booleanArrayOf(true, false, true)
    }

    var nCopy = n
    var exp = 0
    while (nCopy / 3 > 0) {
        exp++
        nCopy /= 3
    }

    val board = dfs(exp, dp)
    print(bw, board)
    bw.flush()
}

fun print(bw: BufferedWriter, board: Array<BooleanArray>) {
    board.forEach {
        it.forEach { i ->
            bw.write(if (i) "*" else " ")
        }
        bw.newLine()
    }
}

fun dfs(exp: Int, dp: Array<Array<BooleanArray>>): Array<BooleanArray> {
    if (dp[exp].isNotEmpty()) {
        return dp[exp]
    }

    var size = 1
    repeat(exp) { size *= 3 }
    val target = Array(size) { BooleanArray(size) }
    applyPattern(target, dfs(exp - 1, dp))
    return target
}

fun applyPattern(target: Array<BooleanArray>, child: Array<BooleanArray>) {
    val step = child.size
    for (r in (target.indices step step)) {
        for (c in (target.indices step step)) {
            if (r == step && c == step)
                continue
            copyArray(target, child, r, c)
        }
    }
}

fun copyArray(target: Array<BooleanArray>, source: Array<BooleanArray>, row: Int, col: Int) {
    val size = source.size
    for (r in (row..<row + size)) {
        for (c in (col..<col + size)) {
            target[r][c] = source[r % size][c % size]
        }
    }
}
