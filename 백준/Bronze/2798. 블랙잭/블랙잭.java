import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] sorted = new int[n];
        int[] numberList = new int[n];

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            numberList[i] = number;
        }

       bubbleSort(numberList);
        System.out.println(blackJack(numberList, n, m));


    }

    public static void bubbleSort(int[] list) {

        for (int pass = list.length - 1; pass > 0; pass--) {
            for (int i = 0; i < pass; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }

    public static int blackJack(int[] sorted, int n, int m) {

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int x = i + 1; x < n - 1; x++) {
                for (int y = x + 1; y < n; y++) {
                    int sum = sorted[i] + sorted[x] + sorted[y];

                    if (m < sum) break;
                    else if (m == sum) return sum;

                    if (max < sum) max = sum;
                }
            }

        }
        return max;
    }
}


