import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int count = sc.nextInt();
        int[] bucket = new int[length];
        int num1, num2, temp;

        for (int i = 0; i < length; i++) {
            bucket[i] = i + 1;
        }

        for(int i = 0; i < count; i++){
            num1 = sc.nextInt() - 1;
            num2 = sc.nextInt() - 1;

            temp = bucket[num1];
            bucket[num1] = bucket[num2];
            bucket[num2] = temp;
        }

        for (int i = 0; i < length; i++) {
            System.out.print(bucket[i] + " ");
        }
    }
}
