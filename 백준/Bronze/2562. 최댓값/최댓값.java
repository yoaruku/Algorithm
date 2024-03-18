import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int length = 9;
        int[] num = new int[length];

        for (int i = 0; i < length; i++) {
            num[i] = sc.nextInt();
        }

        int max = 0;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if(num[i] > max){
                index = i + 1;
                max = num[i];
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
