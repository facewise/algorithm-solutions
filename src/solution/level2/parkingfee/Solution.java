package solution.level2.parkingfee;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, String> map = new HashMap<>();
    Map<String, Integer> times = new HashMap<>();

    public Integer[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] rec = record.split(" ");
            if (!map.containsKey(rec[1])) {
                map.put(rec[1], rec[0]);
                continue;
            }
            String enteredTime = map.get(rec[1]);
            if (times.containsKey(rec[1])) {
                times.put(rec[1], times.get(rec[1]) + sub(enteredTime, rec[0]));
            } else {
                times.put(rec[1], sub(enteredTime, rec[0]));
            }
            map.remove(rec[1]);
        }
        for (String remained : map.keySet()) {
            String enteredTime = map.get(remained);
            if (times.containsKey(remained)) {
                times.put(remained, times.get(remained) + sub(enteredTime));
            } else {
                times.put(remained, sub(enteredTime));
            }
        }
        return times.keySet().stream()
                .sorted()
                .map(times::get)
                .map(i -> calculate(fees, i))
                .toArray(Integer[]::new);
    }

    int calculate(int[] fees, int minute) {
        if (minute <= fees[0]) {
            return fees[1];
        }
        int over = minute - fees[0];
        return ((over % fees[2] == 0) ? over / fees[2] * fees[3] : (over / fees[2] + 1) * fees[3]) + fees[1];
    }

    int sub(String from, String to) {
        String[] var1 = to.split(":");
        String[] var0 = from.split(":");
        int minute = Integer.parseInt(var1[1]) - Integer.parseInt(var0[1]);
        int hour = Integer.parseInt(var1[0]) - Integer.parseInt(var0[0]);
        if (minute < 0) {
            --hour;
            minute += 60;
        }
        return hour * 60 + minute;
    }

    int sub(String from) {
        return sub(from, "23:59");
    }
}
