package solution.level2.truckpassingbridge;

import java.util.ArrayList;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int loaded = 0;
        ArrayList<int[]> list = new ArrayList<>();

        int i = 0;
        do {
            if (i < truck_weights.length) {
                int tmp = truck_weights[i];
                if (list.size() < bridge_length) {
                    if (tmp + loaded <= weight) {
                        list.add(new int[]{tmp, bridge_length});
                        loaded += tmp;
                        i++;
                    }
                }
            }
            answer++;
            list.forEach(arr -> arr[1] -= 1);
            if (list.get(0)[1] == 0) {
                loaded -= list.get(0)[0];
                list.remove(0);
            }
        } while (i < truck_weights.length || list.size() != 0);
        return answer;
    }
}
