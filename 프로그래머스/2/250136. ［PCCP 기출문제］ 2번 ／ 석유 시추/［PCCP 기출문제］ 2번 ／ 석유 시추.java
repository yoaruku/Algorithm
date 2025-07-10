import java.util.*;

class Solution {

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        boolean[][] visited = new boolean[n][m];
        Map<Integer, Integer> oilMap = new HashMap<>(); // oil 덩어리 ID -> 석유량
        List<Set<Integer>> colToOilIds = new ArrayList<>(); // 각 열에 포함된 oil 덩어리 ID
        for (int i = 0; i < m; i++) colToOilIds.add(new HashSet<>());

        int oilId = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int size = 0;
                    Set<Integer> cols = new HashSet<>();
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int x = now[0], y = now[1];
                        size++;
                        cols.add(y);

                        int[] dx = {0, 1, 0, -1};
                        int[] dy = {1, 0, -1, 0};

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (!visited[nx][ny] && land[nx][ny] == 1) {
                                    visited[nx][ny] = true;
                                    queue.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }

                    oilMap.put(oilId, size);
                    for (int col : cols) {
                        colToOilIds.get(col).add(oilId);
                    }
                    oilId++;
                }
            }
        }

        int max = 0;
        for (int col = 0; col < m; col++) {
            int sum = 0;
            for (int id : colToOilIds.get(col)) {
                sum += oilMap.get(id);
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
