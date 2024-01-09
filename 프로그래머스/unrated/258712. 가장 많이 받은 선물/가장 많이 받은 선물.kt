class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val array = Array(friends.size) { 0 }
        val table = Array(friends.size) { Array(friends.size) { 0 } }
        gifts.forEach {
            with(it.split(" ")) {
                table[friends.indexOf(this[0])][friends.indexOf(this[1])] += 1
            }
        }
        val index = Array(friends.size) { idx -> table[idx].sum() - table.sumOf { it[idx] } }
        for (i in table.indices) {
            val row = table[i]
            for (j in row.indices) {
                if (i >= j) continue
                val target = row[j]
                val received = table[j][i]
                val gap = target - received
                if (gap > 0) {
                    array[i] += 1
                } else if (gap < 0) {
                    array[j] += 1
                } else {
                    if (index[i] > index[j]) {
                        array[i] += 1
                    } else if (index[i] < index[j]) {
                        array[j] += 1
                    }
                }
            }
        }
        return array.maxOf { it }
    }
}