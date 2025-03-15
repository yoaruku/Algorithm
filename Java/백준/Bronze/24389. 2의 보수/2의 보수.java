import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int bosu = ~a +1;

        int xor = a ^ bosu;

        int count = 0;
        while (xor != 0){
            count += xor & 1;
            xor >>>= 1;
        }
        System.out.println(count);
    }

}
