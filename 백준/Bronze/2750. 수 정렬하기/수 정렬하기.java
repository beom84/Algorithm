import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        SelectionSort(N);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
/*
   public static void bubblesort(int N) {

        int temp = 0;
        boolean change = true;

        for (int i = N - 1; i > 0 && change; i--) {
            change = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    change = true;
                }
            }
        }
    }
    */
    public static void SelectionSort(int N){
        int i,j,min,temp;
        for(i=0;i<N-1;i++){
            min =i;
            for(j=i+1;j<N;j++){
                if(arr[j]<arr[min]) min = j;
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
