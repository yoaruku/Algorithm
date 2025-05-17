import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i++){

            int m = Integer.parseInt(br.readLine());
            BigInteger max = new BigInteger("0");
            String people = "";
            for (int j = 0 ; j < m; j++){
                String[] input = br.readLine().split(" ");
                BigInteger pay = new BigInteger(input[0]);
                if (max.compareTo(pay) < 0){
                    max = pay;
                    people = input[1];
                }
            }

            System.out.println(people);
        }
    }
}
