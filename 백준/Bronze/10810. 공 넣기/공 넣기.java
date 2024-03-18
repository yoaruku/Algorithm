import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int count = sc.nextInt();
        int[] bucket = new int[length];
        int num1, num2, ballNum;

        for(int i = 0; i < count; i++){
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            ballNum = sc.nextInt();
            for(int j = num1 - 1 ; j <= num2 - 1 ; j++){
                bucket[j] = ballNum;
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(bucket[i] + " ");
        }
    }
}
