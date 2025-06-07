import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        n = 1000 - n;

        int count = 0;
        int temp = 0;

        temp = n / 500;
        count += temp;
        n = n - temp * 500;

        temp = n / 100;
        count += temp;
        n = n - temp * 100;

        temp = n / 50;
        count += temp;
        n = n - temp * 50;

        temp = n / 10;
        count += temp;
        n = n - temp * 10;

        temp = n / 5;
        count += temp;
        n = n - temp * 5;

        temp = n / 1;
        count += temp;
        n = n - temp * 1;

        System.out.println(count);
    }
}
