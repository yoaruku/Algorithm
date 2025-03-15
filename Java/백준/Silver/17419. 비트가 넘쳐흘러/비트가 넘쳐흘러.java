import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String input = br.readLine();

        k = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(input.length() - i - 1) == '1')
                k += 1 << i;
        }

        int count = 0;
        while (k != 0) {
            k -= k & ((~k) + 1);
            count++;
        }

        System.out.println(count);
    }
}
