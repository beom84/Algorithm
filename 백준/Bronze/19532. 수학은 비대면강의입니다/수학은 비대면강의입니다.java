import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = (c * e - f * b) / (a * e - b * d);
        int y = (c * d - f * a) / (b * d - a * e);

        String result = x + " " + y;
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        wr.write(result);
        wr.newLine();
        wr.flush();
    }
}
