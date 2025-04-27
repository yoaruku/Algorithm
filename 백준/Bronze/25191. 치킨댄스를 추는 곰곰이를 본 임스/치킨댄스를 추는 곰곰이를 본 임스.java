import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int coke = Integer.parseInt(input[0]);
        int beer = Integer.parseInt(input[1]);

        coke = coke / 2;

        System.out.println(Math.min(N, coke + beer));
    }
}
