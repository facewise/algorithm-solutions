class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val map = HashMap<String, Int>()
        terms.map { it.split(" ") }.forEach {
            map[it[0]] = it[1].toInt()
        }

        val list = mutableListOf<Int>()
        privacies.forEachIndexed { i, privacy ->
            val split = privacy.split(" ")
            val addedDate = addMonth(split[0], map[split[1]]?:0)
            if (today > addedDate) {
                list.add(i + 1)
            }
        }

        return list.toIntArray()
    }
}

fun addMonth(date: String, month: Int): String {
    val arr = date.split(".").map { it.toInt() }.toMutableList()
    arr[2] -= 1
    arr[1] += month
    if (arr[2] == 0) {
        arr[2] = 28
        arr[1]--
    }
    while (arr[1] > 12) {
        arr[0]++
        arr[1] -= 12
    }
    return arr.joinToString(separator = ".", transform = {
        if (it < 10) "0$it" else "$it"
    })
}