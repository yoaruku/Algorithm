import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int idx = Integer.parseInt(input[1]);

        int count = 0, result = 0;
        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                count++;
                if (count == idx){
                    result = i;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
