import java.io.*;
import java.util.*;

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().trim().toInt()
    val stack = ArrayDeque<Int>()
    repeat(n) {
        val v = br.readLine().trim().toInt()
        if (v == 0) {
            stack.pop()
        } else {
            stack.push(v)
        }
    }
    bw.write("${stack.sum()}")
    bw.flush()
}
