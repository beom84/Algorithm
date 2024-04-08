

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] node;
    static int N, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt((st.nextToken()));

        arr = new int[N + 1][N + 1];
        node = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st_2 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st_2.nextToken());
            int b = Integer.parseInt(st_2.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        //graph 만들기
        count = 0;
        for (int i = 1; i <= N; i++) {
            if (!node[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void DFS(int value) {

        if (node[value]) {
            return;
        }

        node[value] = true;
        for (int i = 1; i <= N; i++) {
            if (arr[value][i] == 1) {
                DFS(i);
            }
        }
    }
}
