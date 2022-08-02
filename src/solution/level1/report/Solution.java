package solution.level1.report;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<Set<String>> list = new ArrayList<>();
        for (String str: id_list)
            list.add(new HashSet<String>());

        for (String str : report) {
            String[] split = str.split(" ");
            list.get(indexOf(id_list,split[1])).add(split[0]);
        }

        for (Set<String> strings : list) {
            if (strings.size() >= k) {
                strings.forEach(x -> answer[indexOf(id_list, x)]++);
            }
        }
        return answer;
    }

    public int indexOf(String[] list, String str) {
        for (int i = 0; i < list.length; i++) {
            if (str.equals(list[i]))
                return i;
        }
        return -1;
    }
}
