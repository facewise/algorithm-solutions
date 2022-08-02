package solution.level2.openchattingroom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (String s : record) {
            String[] split = s.split(" ");
            switch (split[0]) {
                case "Enter":
                    list.add(split[1] + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add(split[1] + "님이 나갔습니다.");
                    break;
                default:
                    break;
            }
            switch (split[0]) {
                case "Change":
                case "Enter":
                    map.put(split[1], split[2]);
                    break;
                default:
                    break;
            }
        }

        list.replaceAll(s -> s.replaceAll(s.substring(0, s.indexOf("님")), map.get(s.substring(0, s.indexOf("님")))));

        return list.toArray(answer);
    }
}
