import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int trubleInt = sc.nextInt();
        
        for (int i = 0; i < (trubleInt/4); i++){
            System.out.print("long ");
        }
        System.out.println("int");
    }
}
