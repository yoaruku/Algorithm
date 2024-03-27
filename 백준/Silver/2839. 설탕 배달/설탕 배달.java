import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int weight = 0;
        weight = sc.nextInt();
        int result = 0;

        for (int i = 0; i <= (weight / 5); i++) {
            if ((weight - (i * 5)) % 3 == 0) {
                result = i + ((weight - (i * 5)) / 3);
            }
        }

        if (result == 0) {
            result = -1;
        }

        System.out.println(result);
    }
}