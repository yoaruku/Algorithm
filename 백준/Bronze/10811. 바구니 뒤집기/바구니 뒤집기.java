import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = sc.nextInt();

        int[] bucket = new int[num];

        for (int i = 0; i < num; i++) bucket[i] = i+1;

        int a,b;
        for (int i = 0; i < count; i++) {
            a = sc.nextInt();
            b = sc.nextInt();


            int temp;
            for(int j = b-1; j >= a-1; j--){
                for (int k = j; k >= a-1; k--) {
                    temp = bucket[k];
                    bucket[k] = bucket[j];
                    bucket[j] = temp;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            System.out.print(bucket[i] + " ");
        }
    }
}