import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int[] dx = {1, 0, -1 , 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(map, false) + " " + bfs(map, true));
    }

    public static int bfs(char[][] map, boolean isCVD) {
        int N = map.length;
        boolean[][] visited = new boolean[N][N];
        int count = 0;
        Deque<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    queue.add(new Node(i, j));
                    visited[i][j] = true;  // ✅ 방문 처리 미리

                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        int x = node.x, y = node.y;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k], ny = y + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                                if (isCVD) {  // 적록색약 (R, G 같은 색)
                                    if ((map[x][y] == 'B' && map[nx][ny] == 'B') ||
                                            ((map[x][y] == 'R' || map[x][y] == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G'))) {
                                        queue.add(new Node(nx, ny));
                                        visited[nx][ny] = true;  // ✅ 방문 처리 미리
                                    }
                                } else {  // 정상인
                                    if (map[x][y] == map[nx][ny]) {
                                        queue.add(new Node(nx, ny));
                                        visited[nx][ny] = true;  // ✅ 방문 처리 미리
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}