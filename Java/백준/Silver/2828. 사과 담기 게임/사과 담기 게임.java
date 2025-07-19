import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int screen = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int left = 1;                  // 바구니의 왼쪽 끝
        int right = M;                // 바구니의 오른쪽 끝
        int count = 0;

        for (int i = 0; i < N; i++) {
            int apple = Integer.parseInt(br.readLine());

            if (apple < left) {
                int move = left - apple;
                count += move;
                left -= move;
                right -= move;
            } else if (apple > right) {
                int move = apple - right;
                count += move;
                left += move;
                right += move;
            }
        }

        System.out.println(count);
    }
}
