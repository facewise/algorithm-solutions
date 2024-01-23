import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[input + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i <= input; i++) {
            if (i % 6 == 0)
                dp[i] = Math.min(dp[i / 3], Math.min(dp[i / 2], dp[i - 1])) + 1;
            else if (i % 3 == 0)
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            else if (i % 2 == 0)
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            else
                dp[i] = Math.min(dp[i - 1], dp[i]) + 1;
        }
        System.out.println(dp[input]);
    }
}