import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char c = '\0';
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (!(ch == c)) {
                c = ch;
                count++;
            }
        }

        System.out.println(count/2);
    }
}
