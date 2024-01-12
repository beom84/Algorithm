
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        int bottom = 0 , top = 0  ;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0;i < n;i++){
            int currentNumber = sc.nextInt();
            if(i == 0){
                bottom = currentNumber;
                top = currentNumber;
            }else{
  /*              if(x < bottom){
                    bottom = x ;
                }else if(x > top){
                    top = x;  를 아래로 바꿔주면 편하다
    */
                bottom = Math.min(bottom,currentNumber);
                top = Math.max(top,currentNumber);
            }
        }
        System.out.println(top*bottom);

        sc.close();
    }
}
