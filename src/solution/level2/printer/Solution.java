package solution.level2.printer;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++)
            list.add(new int[] {priorities[i], i});

        while (true) {
            int[] tmp = list.get(0);
            int i;
            for (i = 0; i < list.size(); i++) {
                if (list.get(i)[0] > tmp[0]) {
                    list.remove(0);
                    list.add(tmp);
                    break;
                }
            }
            if (i == list.size()) {
                if (list.get(0)[1] == location)
                    return answer;
                else {
                    list.remove(0);
                    answer++;
                }
            }
        }

    }
}
