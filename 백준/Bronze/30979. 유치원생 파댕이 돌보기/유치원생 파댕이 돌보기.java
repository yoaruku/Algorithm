
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        while (st.hasMoreTokens()){
            sum += Integer.parseInt(st.nextToken());
        }

        System.out.println( sum >= T ? "Padaeng_i Happy" : "Padaeng_i Cry");

    }
}
