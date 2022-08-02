package solution.level2.stringcompress;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(String s) {
        int answer = s.length();
        Queue<String> queue = new LinkedList<>();
        for (int i = 1; i <= s.length()/2; i++) {
            int startIndex = 0;
            while (startIndex < s.length()) {
                if (startIndex + i <= s.length()) {
                    queue.add(s.substring(startIndex, startIndex + i));
                }
                else {
                    queue.add(s.substring(startIndex));
                }
                startIndex += i;
            }
            String prevToken = null;
            int count = 1;
            StringBuilder compressedString = new StringBuilder();
            while (!queue.isEmpty()) {
                if (prevToken != null) {
                    String thisToken = queue.peek();
                    if (thisToken.equals(prevToken)) {
                        count++;
                    } else {
                        compressedString.append(count).append(prevToken);
                        count = 1;
                    }
                }
                prevToken = queue.poll();
            }
            System.out.println(compressedString);
        }
        return answer;
    }
}
