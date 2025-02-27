import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        int[] each = new int[10];

        for (int i = 0 ; i < number.length(); i++){
            each[number.charAt(i) - 48]++;
        }

        int max = 0;
        for (int i = 0; i < 9; i++){
            if (i != 6){
                max = Math.max(max, each[i]);
            }else{
                int six_nine = (int) Math.ceil((double) (each[6] + each[9]) / 2);
                max = Math.max(max, six_nine);
            }
        }

        System.out.println(max);
    }
}