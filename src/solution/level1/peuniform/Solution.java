package solution.level1.peuniform;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();
        for (int i : reserve)
            reserveList.add(i);
        for (int i : lost) {
            if (reserveList.contains(i)) {
                reserveList.remove((Integer) i);
            } else {
                lostList.add(i);
            }
        }
        Collections.sort(lostList);
        Collections.sort(reserveList);
        int answer = n - lostList.size();
        for (Integer i : lostList) {
            if (reserveList.contains(i - 1)) {
                reserveList.remove((Integer) (i - 1));
                answer++;
            } else if (reserveList.contains(i + 1)) {
                reserveList.remove((Integer) (i + 1));
                answer++;
            }
            if (answer == n) break;
        }
        return answer;
    }
}
