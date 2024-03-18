import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] chess = new int[6];

        for (int i = 0; i < chess.length; i++) {
            chess[i] = sc.nextInt();

            switch (i){
                case 0,1:
                    chess[i] = 1 - chess[i];
                    break;
                case 2,3,4:
                    chess[i] = 2 - chess[i];
                    break;
                case 5:
                    chess[i] = 8 - chess[i];
                    break;
            }
            System.out.print(chess[i] + " ");
        }
    }
}