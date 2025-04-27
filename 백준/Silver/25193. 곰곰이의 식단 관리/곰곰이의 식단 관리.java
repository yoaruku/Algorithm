import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int chicken = 0;
        int other = 1;

        for (char c : arr){
            if (c == 'C'){
                chicken++;
            }
        }

        other += N - chicken;

        int result = (int) Math.ceil((double) chicken / other);

        if( chicken != 0 && result == 0){
            result = 1;
        }

        System.out.println(result);
    }
}
