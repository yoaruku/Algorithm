import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] sosu = new int[num];
        int count = 0;

        for (int i = 0; i < sosu.length; i++) {
            sosu[i] = sc.nextInt();
        }

        for (int i : sosu) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (j == i) {
                        count++;
                    }
                    break;
                }

            }
        }

        System.out.println(count);

    }
}