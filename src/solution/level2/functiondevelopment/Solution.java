package solution.level2.functiondevelopment;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remains = 100 - progresses[i];
            if (remains % speeds[i] == 0) {
                queue.add(remains / speeds[i]);
            } else {
                queue.add(remains / speeds[i] + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        while (queue.peek() != null) {
            int peek = queue.peek();
            int count = 0;
            while (true) {
                if (queue.peek() == null)
                    break;
                if (queue.peek() <= peek) {
                    queue.poll();
                    ++count;
                } else
                    break;
            }
            list.add(count);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
