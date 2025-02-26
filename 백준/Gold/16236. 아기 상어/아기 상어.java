import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist != o.dist) return this.dist - o.dist; // 1. 거리 우선
            if (this.x != o.x) return this.x - o.x; // 2. y 좌표가 작은 것
            return this.y - o.y; // 3. x 좌표가 작은 것
        }
    }

    static int N, sharkSize = 2, eatCount = 0, time = 0;
    static int[][] tank;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1}; // 상, 좌, 우 ,하
    static int[] dy = {0, -1, 1, 0};
    static int sharkX, sharkY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tank = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tank[i][j] = Integer.parseInt(st.nextToken());
                if (tank[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    tank[i][j] = 0; // 상어가 있던 자리 초기화
                }
            }
        }

        while (true) {
            Fish target = findNearestFish();
            if (target == null) break; // 더 이상 먹을 수 있는 물고기가 없으면 종료

            // 상어 이동
            time += target.dist;
            sharkX = target.x;
            sharkY = target.y;
            tank[sharkX][sharkY] = 0; // 먹은 물고기 자리 비우기

            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Fish findNearestFish() {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Fish> fishList = new PriorityQueue<>();
        visited = new boolean[N][N];
        int[][] distance = new int[N][N];

        queue.add(new int[]{sharkX, sharkY});
        visited[sharkX][sharkY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || tank[nx][ny] > sharkSize)
                    continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;

                if (tank[nx][ny] > 0 && tank[nx][ny] < sharkSize) { // 먹을 수 있는 물고기
                    fishList.add(new Fish(nx, ny, distance[nx][ny]));
                }
            }
        }

        return fishList.isEmpty() ? null : fishList.poll();
    }
}