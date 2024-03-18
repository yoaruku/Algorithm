import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] studentId = new int[28];

        for (int i = 0; i < studentId.length; i++) {
            studentId[i] = sc.nextInt();
        }

        boolean isReport = false;
        for(int i = 1; i <= 30; i++){

            for(int j = 0; j < studentId.length; j++){
                if(studentId[j] == i){
                    isReport = true;
                }
            }

            if (!isReport) {
                System.out.println(i);
            }

            isReport = false;
        }
    }
}