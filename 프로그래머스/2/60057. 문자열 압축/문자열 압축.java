public class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        for (int i = 1; i <= len/2; i++) {
            int pos = 0;
            StringBuilder compressed = new StringBuilder();
            while (pos+i <= len) {
                String prev = s.substring(pos, pos+i);
                pos += i;
                int cnt = 1;
                while (pos+i <= len) {
                    String curr = s.substring(pos, pos+i);
                    if (prev.equals(curr)) {
                        cnt++;
                        pos += i;
                    } else {
                        break;
                    }
                }
                if (cnt > 1) {
                    compressed.append(cnt);
                }
                compressed.append(prev);
            }
            if (pos < len) {
                compressed.append(s.substring(pos));
            }
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}