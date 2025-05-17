import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        first:
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            for (int j = 0; Math.pow(2, j) <= num; j++) {
                long powJ = (long) Math.pow(2, j);
                for (int k = j; Math.pow(2, k) <= num - powJ; k++) {
                    long powK = (long) Math.pow(2, k);
                    if (powJ + powK == num) {
                        System.out.println(j + " " + k);
                        continue first;
                    }
                }
            }

            // 만약 찾지 못한 경우
            System.out.println("-1");
        }
    }
}
