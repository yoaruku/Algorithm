import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++){

            if (i % 2 ==1){
                if (i == n)
                    sb.append(3);
                else
                    sb.append(1+" ");
            } else {
                sb.append(2+" ");
            }
        }

        System.out.println(sb);
    }
}
