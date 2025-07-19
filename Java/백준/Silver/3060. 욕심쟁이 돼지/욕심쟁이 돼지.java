import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int foods = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int eat = 0;
            while (st.hasMoreTokens()){
                eat += Integer.parseInt(st.nextToken());
            }

            int count = 1;
            while (eat <= foods){
                eat *= 4;
                count++;
            }

            System.out.println(count);
        }

    }
}
