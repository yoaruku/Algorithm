import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        // 공집합 표현을 위해 인덱스가 한 줄씩 추가 됨
        int[][] map = new int[str1.length() + 1][str2.length() + 1];

        // 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음)
        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {

                // (i-1)과 (j-1) 번째 문자가 서로 같다면
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    // 대각선 위 (i-1, j-1)의 map에 +1 한 값으로 갱신
                    map[i][j] = map[i - 1][j - 1] + 1;
                }

                // 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
                else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }

        System.out.println(map[str1.length()][str2.length()]);
    }
}
