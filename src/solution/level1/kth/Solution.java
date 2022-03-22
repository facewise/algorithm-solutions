package solution.level1.kth;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = new int[100];
            int num = commands[i][2];
            for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
                temp[array[j]]++;
            }
            for (int j = 0; j < temp.length; j++) {
                num -= temp[j];
                if (num < 1) {
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }
}