import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static final char EMPTY = '.';

    public static int solution(String[] storage, String[] requests) {
        char[][] charArr = strArrToCharArr(storage);

        for (String req : requests) {
            char target = req.charAt(0);

            // 크레인 조건: 같은 알파벳이 두 번 반복된 경우만 ("BB")
            boolean isCrane = (req.length() == 2 && req.charAt(0) == req.charAt(1));

            if (isCrane) {
                // 크레인은 해당 알파벳 전부 제거
                for (int i = 0; i < charArr.length; i++) {
                    for (int j = 0; j < charArr[i].length; j++) {
                        if (charArr[i][j] == target) {
                            charArr[i][j] = EMPTY;
                        }
                    }
                }
            } else {
                // 외부 공기 지도 생성
                boolean[][] ext = markExternalAir(charArr);

                // 지게차는 외부와 접한 같은 종류만 제거
                List<int[]> del = new ArrayList<>();
                for (int i = 0; i < charArr.length; i++) {
                    for (int j = 0; j < charArr[i].length; j++) {
                        if (charArr[i][j] == target) {
                            for (int d = 0; d < 4; d++) {
                                int ni = i + dx[d], nj = j + dy[d];
                                if (ni < 0 || nj < 0 || ni >= charArr.length || nj >= charArr[0].length) {
                                    del.add(new int[]{i, j});
                                    break;
                                }
                                if (ext[ni][nj]) {
                                    del.add(new int[]{i, j});
                                    break;
                                }
                            }
                        }
                    }
                }
                for (int[] p : del) charArr[p[0]][p[1]] = EMPTY;
            }
        }

        return counting(charArr);
    }

    public static char[][] strArrToCharArr(String[] strArr) {
        char[][] charArr = new char[strArr.length][strArr[0].length()];
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length(); j++) {
                charArr[i][j] = strArr[i].charAt(j);
            }
        }
        return charArr;
    }

    public static boolean[][] markExternalAir(char[][] g) {
        int n = g.length, m = g[0].length;
        boolean[][] ext = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 경계에 있는 빈칸에서 BFS 시작
        for (int i = 0; i < n; i++) {
            if (g[i][0] == EMPTY) { ext[i][0] = true; q.add(new int[]{i, 0}); }
            if (g[i][m - 1] == EMPTY) { ext[i][m - 1] = true; q.add(new int[]{i, m - 1}); }
        }
        for (int j = 0; j < m; j++) {
            if (g[0][j] == EMPTY) { ext[0][j] = true; q.add(new int[]{0, j}); }
            if (g[n - 1][j] == EMPTY) { ext[n - 1][j] = true; q.add(new int[]{n - 1, j}); }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!ext[nx][ny] && g[nx][ny] == EMPTY) {
                    ext[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return ext;
    }

    public static int counting(char[][] charArr) {
        int count = 0;
        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < charArr[i].length; j++) {
                if ('A' <= charArr[i][j] && charArr[i][j] <= 'Z') {
                    count++;
                }
            }
        }
        return count;
    }
}