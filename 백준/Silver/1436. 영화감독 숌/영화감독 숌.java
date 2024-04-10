import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        int input = 0;
        int count = 0;
        int num = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            input = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            num++;

            String str = String.valueOf(num);
            if (str.contains("666")) {
                count++;
            }

            if (count == input) {
                System.out.println(str);
                break;
            }
        }
    }
}