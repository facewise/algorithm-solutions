package solution.level1.supoja;

public class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[] foo = new int[]{2,1,2,3,2,4,2,5};
        int[] bar = new int[]{3,1,2,4,5};

        for (int i = 0; i < answers.length; i++) {
            score[0] = (answers[i] == (i % 5) + 1) ? score[0] + 1 : score[0];
            if (foo[i % 8] == answers[i])
                score[1]++;
            if (bar[(i/2)%5] == answers[i])
                score[2]++;
        }

        if (score[0] > score[1]) {
            if (score[0] > score[2])
                return new int[]{1};
            else if (score[0] == score[2])
                return new int[]{1, 3};
            else
                return new int[]{3};
        }
        else if (score[0] < score[1]) {
            if (score[1] > score[2])
                return new int[]{2};
            else if (score[1] == score[2])
                return new int[]{2,3};
            else
                return new int[]{3};
        }
        else {
            if (score[0] == score[2])
                return new int[]{1,2,3};
            else if (score[0] > score[2])
                return new int[]{1,2};
            else
                return new int[]{3};
        }
    }
}