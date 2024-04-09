import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] node;
    static int N, V;
    static Queue<Integer> Q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        node = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st_2 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st_2.nextToken());
            int b = Integer.parseInt(st_2.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(V);

        node = new boolean[N+1];
        sb.append("\n");

        bfs(V);

        System.out.println(sb);

    }

    static void dfs(int V) {
        if (node[V]) return;

        node[V] = true;
        sb.append(V + " ");

        for (int i = 1; i <= N; i++) {
            if (arr[V][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int V) {
        Q.offer(V);

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {

                int v = Q.poll();

                if(!node[v]) {
                    node[v] = true;
                    sb.append(v + " ");
                }
                for (int j = 1; j <= N; j++) {
                    if (arr[v][j] == 1 && !node[j]) {
                        Q.offer(j);
                    }
                }
            }
        }
    }
}
