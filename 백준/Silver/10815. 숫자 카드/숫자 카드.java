import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer>  number_cards = new HashSet<>();

        StringTokenizer st_N = new StringTokenizer(br.readLine());

        for(int i = 0;i<N;i++){
            number_cards.add(Integer.parseInt(st_N.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st_M = new StringTokenizer(br.readLine());

        for(int i = 0;i<M;i++){
           if(number_cards.contains(Integer.parseInt(st_M.nextToken())))
               System.out.print("1 ");
           else
               System.out.print("0 ");
        }
    }
}
