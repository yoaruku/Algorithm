import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt() % 42;
        }

        Arrays.sort(num);
        boolean isDup = false;
        int count = 0;

        for (int i = 0; i < num.length; i++) {

            for(int j = i + 1; j < num.length; j++){
                if(num[i] == num[j]){
                    isDup = true;
                }
            }

            if (!isDup) {
                count++;
            }

            isDup = false;
        }
        System.out.println(count);
    }
}