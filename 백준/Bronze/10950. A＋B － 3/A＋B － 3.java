import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int loop = sc.nextInt();

        int[] arr1 = new int[loop];
        int[] arr2 = new int[loop];

        for(int i = 0; i < loop; i++){
            arr1[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }

        for(int i = 0; i < loop; i++){
            System.out.println(arr1[i] + arr2[i]);
        }
    }
}
