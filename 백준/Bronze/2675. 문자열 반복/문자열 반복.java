import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {

            int loop = sc.nextInt();

            String str = sc.next();

            for (int j = 0; j < str.length(); j++) {
                for(int k = 0; k < loop; k++){
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }
}