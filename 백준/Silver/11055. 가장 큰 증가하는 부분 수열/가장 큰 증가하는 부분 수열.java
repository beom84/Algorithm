import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for(int i = 1; i < N; i++) {
            dp[i] = 0;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]+arr[i]) {
                    dp[i] = dp[j]+arr[i];
                }else if(dp[i] == 0){
                    dp[i] = arr[i];
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }
}
