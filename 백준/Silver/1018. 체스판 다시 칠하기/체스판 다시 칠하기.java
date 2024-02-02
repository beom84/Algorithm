
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static boolean[][] square;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int small_a = a - 7;
        int small_b = b - 7;
        square = new boolean[a][b];

        for (int i = 0; i < a; i++) {
            String str = br.readLine();
            for (int j = 0; j < b; j++) {
                if (str.charAt(j) == 'W') {
                    square[i][j] = true;        // W일 때는 true
                } else {
                    square[i][j] = false;

                }
            }
        }

        int result = min;
        for (int i = 0; i < small_a; i++) {
            for (int j = 0; j < small_b; j++) {
                result = Math.min(result, find(i, j));
                if (result == 0) {
                    System.out.println(result);
                    exit(0);
                }
            }
        }
        System.out.println(result);
    }

    public static int find(int x, int y) {

        boolean TF = square[0][0];
        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (square[i][j] != TF) {
                    count++;
                }
                TF = !TF;
            }
            TF = !TF;
        }
        int result = Math.min(count, min - count);
        return result;
    }
}
