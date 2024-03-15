import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long totalPrice = sc.nextLong();
        int totalCount = sc.nextInt();

        int[] thingPrice = new int[totalCount];
        int[] thingCount = new int[totalCount];

        for(int i = 0; i < totalCount; i++){
            thingPrice[i] = sc.nextInt();
            thingCount[i] = sc.nextInt();
        }

        int verif = 0;
        for(int i = 0; i < totalCount; i++){
            verif += thingPrice[i] * thingCount[i];
        }

        if(verif == totalPrice){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
