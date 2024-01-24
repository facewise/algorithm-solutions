class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 시작 시간이 0시 0분 0초인 경우 시작하자마자 울리므로 예외 처리
        int exception = (h1 % 12 == 0 && m1 == s1 && s1 == 0) ? 1 : 0;
        return countAlarm(h2, m2, s2) - countAlarm(h1, m1, s1) + exception;
    }

    /**
     * h시 m분 s초 까지 총 시간(초)
     */
    int totalSec(int h, int m, int s) {
        return 3600 * h + 60 * m + s;
    }

    /**
     * 0시 0분 0초부터 h시 m분 s초 까지의 알람 횟수
     * 0시 0분 0초에 울리는 알람은 제외됨.
     */
    int countAlarm(int h, int m, int s) {
        int totalSec = totalSec(h, m, s);

        // 초침과 분침은 3600/59초마다 만남
        int minAlarm = totalSec * 59 / 3600;

        // 초침과 시침은 43200/719초마다 만남
        int hourAlarm = totalSec * 719 / 43200;
        
        // 12시 0분 0초 이상인 경우에는 시침 분침 초침이 겹치므로 1회 빼야함
        int exception = totalSec >= 43200 ? 1 : 0;
            
        return minAlarm + hourAlarm - exception;
    }
}
