import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[][] bingGo = new int[5][5];
    public static boolean[][] bingGoPan = new boolean[5][5];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            String[] bingGoInput = br.readLine().split(" ");

            for (int j = 0; j< bingGoInput.length; j++){
                bingGo[i][j] = Integer.parseInt(bingGoInput[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < 5; i++){
            String[] commandInput = br.readLine().split(" ");

            for (int j = 0; j< commandInput.length; j++){
                int input = Integer.parseInt(commandInput[j]);
                count++;

                for (int k = 0 ; k < 5; k++){
                    for (int l = 0; l < 5; l++){
                        if (bingGo[k][l] == input)
                            bingGoPan[k][l] = true;

                        if (checkBingGo() >= 3){
                            System.out.println(count);
                            return;
                        }
                    }
                }
            }
        }


    }

    public static int checkBingGo(){

        int bingGoCount = 0;

        for (int i = 0 ; i < 5; i++){
            int count = 0;

            for (int j = 0 ;j < 5; j++){
                if (bingGoPan[i][j])
                    count++;
            }

            if (count == 5)
                bingGoCount++;
        }

        for (int j = 0 ; j < 5; j++){
            int count = 0;

            for (int i = 0 ;i < 5; i++){
                if (bingGoPan[i][j])
                    count++;
            }

            if (count == 5)
                bingGoCount++;
        }

        for (int i = 0, j =0, count = 0; i < 5; i++, j++){

            if (bingGoPan[i][j])
                count++;

            if (count == 5)
                bingGoCount++;
        }

        for (int i = 0, j =4, count = 0; i < 5; i++, j--){

            if (bingGoPan[i][j])
                count++;

            if (count == 5)
                bingGoCount++;
        }

        return bingGoCount;
    }
}
