import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int target = sc.nextInt();
        int[] num = new int[length];

        for (int i = 0; i < length; i++) {
            num[i] = sc.nextInt();
        }

        for(int i = 0; i < length; i++){
            if(num[i] < target) System.out.print(num[i] + " ");
        }
    }
}
