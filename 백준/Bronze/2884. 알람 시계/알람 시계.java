import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if (num2 < 45){
            if(num1 > 0){
                num1 -= 1;
            }
            else{
                num1 = 23;
            }

            num2 = 60 - 45 + num2;
        }
        else{
            num2 -= 45;
        }

        System.out.print(num1 + " " + num2);
    }
}
