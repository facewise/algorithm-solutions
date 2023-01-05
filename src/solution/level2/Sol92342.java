package solution.level2;

public class Sol92342 {
    int maxGap = 0;
    int[] answer = new int[]{-1};
    int[] gInfo;

    public int[] solution(int n, int[] info) {
        gInfo = info;
        dfs(0, n, new int[11]);
        return answer;
    }

    void dfs(int start, int n, int[] result) {
        if (n <= 0) {
            int[] tmp = result.clone();
            replaceMap(tmp);
            return;
        }
        if (start == 10) {
            int[] tmp = result.clone();
            if (n > 0) {
                tmp[10] = n;
            }
            replaceMap(tmp);
            return;
        }
        int apeach = gInfo[start];
        if (n > apeach) {
            result[start] = apeach + 1;
            dfs(start + 1, n - (apeach + 1), result);
        }
        result[start] = 0;
        dfs(start + 1, n, result);
    }

    void replaceMap(int[] result) {
        int point = 0;
        int apeachPoint = 0;
        for (int i = 0; i < 11; i++) {
            if (gInfo[i] > result[i]) {
                apeachPoint += 10 - i;
            } else if (gInfo[i] == result[i] && result[i] != 0) {
                apeachPoint += 10 - i;
            } else if (gInfo[i] < result[i]) {
                point += 10 - i;
            }
        }
        int gap = point - apeachPoint;
        if (point <= apeachPoint || gap < maxGap)
            return;
        if (gap > maxGap) {
            answer = result;
            maxGap = gap;
        } else {
            for (int i = 10; i >= 0; i--) {
                if (result[i] > answer[i]) {
                    answer = result;
                    return;
                } else if (result[i] < answer[i]) {
                    return;
                }
            }
        }
    }
}
