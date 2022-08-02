package skillcheck.level2;

public class Solution {
    public long solution(int n) {
        long answer = 0;
        for (int x = 0; x <= n/2; x++) {
            for (int y = 0; y <= n; y++) {
                if (2*x + y == n) {
                    answer += combination(x+y,x);
                }
            }
        }
        return answer%1234567L;
    }
    public int factorial(int n) {
        if (n < 2) return 1;
        else
            return n*factorial(n-1);
    }
    public long combination(int n, int r) {
        return factorial(n)/factorial(r)/factorial(n-r);
    }
}