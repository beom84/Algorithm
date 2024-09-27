
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static int MOD = 1000000000;
    static Long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        dp = new Long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 1; i <= 9; i++) {
            sum += recur(N, i);
        }
        System.out.println(sum%MOD);
    }

    static Long recur(int digit, int val) {
        if (digit == 1) {
            return dp[digit][val];
        }
        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = recur(digit - 1, val + 1);
            } else if (val == 9) {
                dp[digit][val] = recur(digit - 1, val - 1);
            } else {
                dp[digit][val] = recur(digit - 1, val + 1) + recur(digit - 1, val - 1);
            }
        }
        return dp[digit][val] % MOD;
    }
}
