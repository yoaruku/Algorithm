import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n, m, loop;
    public static int[][] map;
    public static int airCleaner = -1;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] setting = br.readLine().split(" ");
        n = Integer.parseInt(setting[0]);
        m = Integer.parseInt(setting[1]);
        loop = Integer.parseInt(setting[2]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
            if (map[i][0] == -1 && airCleaner == -1) {
                airCleaner = i;
            }
        }

        for (int i = 0; i < loop; i++) {
            diffusionDust();
            operateAirCleaner();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1) {
                    result += map[i][j];
                }
            }
        }

        System.out.println(result);
    }

    public static void diffusionDust() {
        int[][] tempMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempMap[i][j] = map[i][j]; // 기존 값 유지
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    int splitDust = map[i][j] / 5;
                    int count = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != -1) {
                            tempMap[nx][ny] += splitDust;
                            count++;
                        }
                    }

                    tempMap[i][j] -= splitDust * count;
                }
            }
        }

        map = tempMap;
    }

    public static void operateAirCleaner() {
        int upper = airCleaner;
        int lower = airCleaner + 1;

        // 공기청정기 상단
        for (int i = upper - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < m - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < upper; i++) {
            map[i][m - 1] = map[i + 1][m - 1];
        }
        for (int i = m - 1; i > 1; i--) {
            map[upper][i] = map[upper][i - 1];
        }

        // 공기청정기 하단
        for (int i = lower + 1; i < n - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < m - 1; i++) {
            map[n - 1][i] = map[n - 1][i + 1];
        }
        for (int i = n - 1; i > lower; i--) {
            map[i][m - 1] = map[i - 1][m - 1];
        }
        for (int i = m - 1; i > 1; i--) {
            map[lower][i] = map[lower][i - 1];
        }

        // 공기청정기 위치 정리
        map[upper][0] = -1;
        map[lower][0] = -1;
        map[upper][1] = 0;
        map[lower][1] = 0;
    }
}