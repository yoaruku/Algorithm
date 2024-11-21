import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            // 첫 번째 줄: 상근이와 선영이의 CD 개수
            String[] cds = br.readLine().split(" ");
            int N = Integer.parseInt(cds[0]);
            int M = Integer.parseInt(cds[1]);

            // 종료 조건: 0 0 입력
            if (N == 0 && M == 0) break;

            // 상근이의 CD 번호 저장
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            // 선영이의 CD 번호와 비교
            int duplicateCount = 0;
            for (int i = 0; i < M; i++) {
                int cd = Integer.parseInt(br.readLine());
                if (set.contains(cd)) {
                    duplicateCount++;
                }
            }

            // 결과 저장
            sb.append(duplicateCount).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
        br.close();
    }
}
