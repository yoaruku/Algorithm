import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 여학생 수
        int M = Integer.parseInt(st.nextToken()); // 남학생 수
        int K = Integer.parseInt(st.nextToken()); // 인턴으로 나가야 할 인원 수

        // 최대 팀 수
        int team = Math.min(N / 2, M);

        // 남은 인원
        int remain = N + M - team * 3;

        // 인턴으로 나가야 할 인원 때문에, 팀을 해체할 필요가 있는지 계산
        if (remain < K) {
            // 팀을 해체하면서 K명을 확보
            int needed = K - remain;
            // 팀 하나 해체하면 3명 확보되므로, (올림)
            team -= (needed + 2) / 3;
        }

        System.out.println(team);
    }
}
