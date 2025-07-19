import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sNum = br.readLine();

        if (!sNum.contains("0")){
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (char num : sNum.toCharArray()){
            sum += num-48;
        }

        if (sum % 3 != 0){
            System.out.println(-1);
            return;
        }

        char[] sort = sNum.toCharArray();
        Arrays.sort(sort);
        StringBuilder sb = new StringBuilder(new String(sort)).reverse();
        System.out.println(sb);
    }
}
