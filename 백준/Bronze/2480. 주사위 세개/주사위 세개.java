import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int max = Math.max(num1 , Math.max(num2, num3));
        int equal = 0;

        if (num1 == num2 && num1 == num3){
            System.out.println(10000 + (num1 * 1000));
        }
        else if(num1 == num2 || num1 == num3 || num2 == num3){

            if(num1 == num2) equal = num1;
            if(num1 == num3) equal = num1;
            if(num2 == num3) equal = num2;

            System.out.println(1000 + (equal * 100));
        }
        else {
            System.out.println(max * 100);
        }
    }
}
