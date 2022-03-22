package com.solution.level1.marathon;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else
                map.put(name, 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
            if (map.get(name) == 0)
                map.remove(name);
        }

        answer = map.keySet().toString().replace("[", "").replace("]","");
        return answer;
    }
}