import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String num = st.nextToken();
            N = Integer.parseInt(st.nextToken());

            arr = new int[num.length()];
            int i = 0;
            for (char c : num.toCharArray()) {
                arr[i] = c - '0';
                i++;
            }

            if (arr.length < N) {
                N = arr.length;
            }

            dfs(0,0);

            sb.append("#" + tc + " " + max + "\n");
            max = 0;

        }
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == N) {
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                result += (int) Math.pow(10, i) * arr[arr.length - i - 1];
            }
            max = Math.max(max, result);
        } else {
            for (int i = start; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    swap(i, j);
                    dfs(i, depth + 1);
                    swap(i, j);
                }
            }
        }
    }

    static void swap(int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}