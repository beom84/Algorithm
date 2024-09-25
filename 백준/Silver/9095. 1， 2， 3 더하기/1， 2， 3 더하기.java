import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int max = 0;
        int[] t = new int[N + 1];

        for (int i = 0; i < N; i++) {
            t[i] = sc.nextInt();

            if (max < t[i]) {
                max = t[i];
            }
        }

        int[] dp = new int[max + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= max; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        for(int i = 0; i < N; i++) {
           System.out.print(dp[t[i]] + "\n");
       }
    }
}
