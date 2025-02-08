import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < input[0].length(); j++) {
                if (input[0].charAt(j) == 'X' || input[0].charAt(j) == 'x') {
                    System.out.print(Character.toUpperCase(input[1].charAt(j)));
                    break;
                }
            }
        }
    }
}
