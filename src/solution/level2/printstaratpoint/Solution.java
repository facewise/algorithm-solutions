package solution.level2.printstaratpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String[] solution(int[][] line) {
        List<long[]> list = new ArrayList<>();
        for (long x = -2000L; x <= 2000L; x++) {
            for (long y = -2000L; y <= 2000L; y++) {
                int count = 0;
                for (int[] array : line) {
                    long a = array[0];
                    long b = array[1];
                    long c = array[2];
                    if (a*x + b*y + c == 0L) {
                        count++;
                    }
                    if (count > 1) {
                        list.add(new long[]{x, y});
                        break;
                    }
                }
            }
        }
        long leftX = 2000L, rightX = -2000L, topY = -2000L, bottomY = 2000L;
        for (long[] array : list) {
            if (array[0] < leftX)
                leftX = array[0];
            if (array[0] > rightX)
                rightX = array[0];
            if (array[1] > topY)
                topY = array[1];
            if (array[1] < bottomY)
                bottomY = array[1];
        }
        long xLength = rightX - leftX + 1L;
        long yLength = topY - bottomY + 1L;
        long finalLeftX = leftX;
        long finalTopY = topY;
        list.forEach(arr -> {
            arr[0] -= finalLeftX;
            arr[1] = -1L * (arr[1] - finalTopY);
        });
        String[][] draw = new String[(int) yLength][(int) xLength];
        String[] answer = new String[(int) yLength];
        for (String[] s : draw)
            Arrays.fill(s, ".");

        list.forEach(arr -> draw[(int) arr[1]][(int) arr[0]] = "*");
        int i = 0;
        for (String[] arr : draw) {
            String tmp = "";
            for (String s : arr) {
                tmp += s;
            }
            answer[i++] = tmp;
        }
        return answer;
    }
}