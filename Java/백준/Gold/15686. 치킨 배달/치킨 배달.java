import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[][] map;
    public static List<Chicken> chickens;
    public static List<House> houses;
    public static int minDistance = Integer.MAX_VALUE;

    public static class Chicken {
        int x;
        int y;
        boolean open;

        Chicken(int x, int y) {
            this.x = x;
            this.y = y;
            open = false;
        }
    }

    public static class House {
        int x;
        int y;

        House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    chickens.add(new Chicken(i, j));
                } else if (map[i][j] == 1) {
                    houses.add(new House(i, j));
                }
            }
        }

        brute(0, 0);

        System.out.println(minDistance);
    }

    // 치킨집 조합 브루트포스
    public static void brute(int count, int index) {
        if (count == M) {
            // 선택된 M개의 치킨집으로 도시 치킨거리 계산
            int distanceSum = 0;

            for (House house : houses) {
                int min = Integer.MAX_VALUE;
                for (Chicken chicken : chickens) {
                    if (chicken.open) {
                        int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                        min = Math.min(min, dist);
                    }
                }
                distanceSum += min;
            }

            minDistance = Math.min(minDistance, distanceSum);
            return;
        }

        // 백트래킹으로 치킨집 선택
        for (int i = index; i < chickens.size(); i++) {
            chickens.get(i).open = true;
            brute(count + 1, i + 1);
            chickens.get(i).open = false; // 백트래킹
        }
    }
}
