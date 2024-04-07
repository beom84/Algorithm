import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static String[] arr;
    static int L;
    static int C;
    static List<String> list = Arrays.asList("a", "e", "i", "o", "u");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];

        StringTokenizer st_2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st_2.nextToken();
        }
        Arrays.sort(arr);

        dfs("", 0, 0);
    }

    static void dfs(String origin, int depth, int start) {
        if (depth == L) {
            if (countVowels(origin) >= 1 && L - countVowels(origin) >= 2) {
                System.out.println(origin);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            dfs(origin + arr[i], depth + 1, i + 1);
        }
    }

    static int countVowels(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (list.contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }
}