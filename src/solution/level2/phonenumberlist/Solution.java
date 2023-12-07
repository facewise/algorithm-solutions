package solution.level2.phonenumberlist;

import java.util.HashMap;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (String s : phone_book) {
            for (int i = 0; i < s.length(); i++)
                if (map.containsKey(s.substring(0, i)))
                    return false;
        }

        return answer;
    }
}