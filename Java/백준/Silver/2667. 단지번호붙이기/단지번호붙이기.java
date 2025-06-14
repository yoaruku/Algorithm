import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0 ,-1};
    static int[] dy = {1, 0, -1 ,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0 ; i < n; i++){

            char[] input = br.readLine().toCharArray();
            for (int j = 0 ; j < n; j++){
                map[i][j] = Character.getNumericValue(input[j]);
            }
        }

        PriorityQueue<Integer> result = getAptArray(map);

        System.out.println(result.size());
        while (!result.isEmpty()){
            System.out.println(result.poll());
        }
    }

    public static PriorityQueue<Integer> getAptArray(int[][] map){

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0 ; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                int count = dfs(i,j);
                if (count != -1)
                    queue.offer(count);
            }
        }

        return queue;
    }

    public static int dfs(int x, int y) {

        if (map[x][y] != 1)
            return -1;

        if (visit[x][y])
            return -1;

        visit[x][y] = true;

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    int child = dfs(nx, ny);
                    if (child != -1)
                        count += child;
                }
            }
        }

        return  count + 1;
    }
}
