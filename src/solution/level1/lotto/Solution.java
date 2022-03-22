package solution.level1.lotto;

import java.util.HashSet;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};
        HashSet<Integer> lottoSet = new HashSet<>();
        HashSet<Integer> winSet = new HashSet<>();

        for (Integer i : win_nums) winSet.add(i);

        int count = 0;
        for (Integer i : lottos) {
            if (i != 0) lottoSet.add(i);
            else count++;
        }

        for (Integer i : lottoSet) {
            if (winSet.contains(i))
                answer[1]--;
        }

        answer[0] = answer[1] - count;

        answer[0] = answer[0] == 7 ? 6 : answer[0];
        answer[1] = answer[1] == 7 ? 6 : answer[1];

        return answer;
    }
}