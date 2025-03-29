import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int count = 1;

        while (a<b) {
            if (b % 10 == 1 && b / 10 >= a) {
                b /= 10;
            } else if(b%2 == 0) {
                b /= 2;
            } else {
                break;
            }
            count++;
        }

        System.out.println(a==b? count : -1);
    }
}
