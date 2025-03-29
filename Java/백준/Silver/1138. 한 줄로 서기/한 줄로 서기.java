import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] line = new int[N]; // 줄 서기 결과를 담을 배열

        for (int i = 0; i < N; i++) {
            int num = i + 1; // 사람 번호 (1번부터)
            int more = Integer.parseInt(input[i]);

            int count = 0;

            for (int j = 0; j < N; j++) {
                if (line[j] == 0) { // 비어있는 자리일 때만
                    if (count == more) {
                        line[j] = num;
                        break;
                    }
                    count++;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int n : line) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}
