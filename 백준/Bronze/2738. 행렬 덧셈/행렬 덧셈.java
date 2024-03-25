import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x,y;

        x = sc.nextInt();
        y = sc.nextInt();

        int[][] arr1 = new int[x][y];
        int[][] arr2 = new int[x][y];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = sc.nextInt();

                arr1[i][j] += arr2[i][j];
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

    }
}