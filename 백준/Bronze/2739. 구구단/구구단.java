import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();

        for(int i = 1; i <= 9; i++){
            System.out.println(num1 + " * " + i + " = " + num1 * i);
        }
    }
}
