package skillcheck.level1;

public class Solution {
    public boolean solution(String s) {
        int p = 0, y = 0;
        String tmp = s.toLowerCase();
        char[] array = tmp.toCharArray();
        for (char c : array) {
            p = (c == 'p') ? p + 1 : p;
            y = (c == 'y') ? y + 1 : y;
        }
        return p == y;
    }
}
