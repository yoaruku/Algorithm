import java.io.*;
import java.util.*;

public class Main {
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        Queue<Tomato> queue = new LinkedList<>();
        int totalTomatoes = 0, ripeTomatoes = 0;

        // 입력 받기 & 초기 익은 토마토 큐에 넣기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new Tomato(i, j));
                    ripeTomatoes++; // 처음부터 익은 토마토 개수 카운트
                }
                if (map[i][j] != -1) {
                    totalTomatoes++; // 전체 익거나 익지 않은 토마토 개수
                }
            }
        }

        // BFS 탐색
        int days = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            days++; // 하루 증가

            for (int i = 0; i < size; i++) {
                Tomato tomato = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = tomato.x + dx[d];
                    int ny = tomato.y + dy[d];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 0) {
                        map[nx][ny] = 1; // 익음 처리
                        queue.add(new Tomato(nx, ny));
                        ripeTomatoes++; // 익은 토마토 개수 증가
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(ripeTomatoes == totalTomatoes ? days : -1);
    }

    static class Tomato {
        int x, y;
        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
