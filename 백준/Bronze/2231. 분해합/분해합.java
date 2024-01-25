

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int N_length =  String.valueOf(N).length();
        int result = 0;

        for(int i = (N - (N_length * 9)); i < N; i++) {
            int number = i;
            int sum = 0;	// 각 자릿수 합 변수

            while(number != 0) {
                sum += number % 10;	// 각 자릿수 더하기
                number /= 10;
            }

            // i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
            if(sum + i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);

    }
}

// 1. 그냥 노가다로 분해합 만큼 뺀다음에 구하는것...
// 2.
