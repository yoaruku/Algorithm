import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] num = new int[length];

        for (int i = 0; i < length; i++) {
            num[i] = sc.nextInt();
        }

        int min = num[0];
        int max = num[0];

        for (int i = 0; i < length; i++) {
            min = Math.min(min,num[i]);
            max = Math.max(max,num[i]);
        }

        System.out.print(min + " " + max);
    }
}
