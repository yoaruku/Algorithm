import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int swNum1 = (num1 / 100) + (num1 % 100 / 10 * 10) + (num1 % 10 * 100);
        int swNum2 = (num2 / 100) + (num2 % 100 / 10 * 10) + (num2 % 10 * 100);

        System.out.println((swNum1>swNum2)?swNum1:swNum2);
    }
}