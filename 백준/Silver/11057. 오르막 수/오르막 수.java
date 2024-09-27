import java.util.Scanner;

public class Main {
    static Integer[][] dp;
    final static int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new Integer[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        int result = 0;

        for (int i = 0; i < 10; i++) {
            result += recur(n, i) % MOD;
        }
        System.out.println(result % MOD);
    }

    static int recur(int digit, int val) {
        if (digit == 1) {
            return dp[digit][val];
        }

        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = 1;
            } else {
                int sum = 0;
                for (int i = 0; i <= val; i++) {
                    sum += recur(digit - 1, i);
                    dp[digit][val] = sum % MOD;
                }
            }
        }
        return dp[digit][val];
    }
}
