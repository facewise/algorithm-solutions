package solution.level2.country124;

import java.util.Stack;

public class Solution {
    public String solution(int n) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        int pow = 0;
        while (n > 0) {
            int tmp = n / (int)Math.pow(3, pow);
            stack.add(convert(((tmp - 1) % 3) + 1));
            if (tmp > 3) {
                n -= (int)Math.pow(3, pow);
                pow++;
            } else {
                break;
            }
        }
        while (!stack.isEmpty())
            answer += stack.pop();

        return answer;
    }
    public int convert(int n) {
        if (n == 3)
            return 4;
        return n;
    }
}
