import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] num = new int[length];

        for (int i = 0; i < length; i++) {
            num[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        int count = 0;

        for(int i = 0; i < length; i++){
            if(num[i] == target){
                count++;
            }
        }

        System.out.println(count);
    }
}
