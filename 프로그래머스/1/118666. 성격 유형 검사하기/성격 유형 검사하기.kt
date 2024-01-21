class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val score = IntArray(4)
        for (index in survey.indices) {
            when (survey[index]) {
                "RT" -> score[0] += choices[index] - 4
                "TR" -> score[0] += 4 - choices[index]
                "CF" -> score[1] += choices[index] - 4
                "FC" -> score[1] += 4 - choices[index]
                "JM" -> score[2] += choices[index] - 4
                "MJ" -> score[2] += 4 - choices[index]
                "AN" -> score[3] += choices[index] - 4
                "NA" -> score[3] += 4 - choices[index]
            }
        }
        return "${if (score[0] > 0) "T" else "R"}${if (score[1] > 0) "F" else "C"}${if (score[2] > 0) "M" else "J"}${if (score[3] > 0) "N" else "A"}"
    }
}
