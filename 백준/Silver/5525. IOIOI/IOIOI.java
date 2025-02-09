
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int idx = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String target = "I";
        int count = 0;

        for (int i = 0; i < N; i++) {
            target += "OI";
        }

        while (str.contains(target)){
            str = str.replaceFirst(target, target.substring(0, target.length() - 2));
            count++;
        }

        System.out.println(count);
    }
}
