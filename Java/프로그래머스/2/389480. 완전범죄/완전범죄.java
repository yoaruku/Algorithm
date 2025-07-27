import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        boolean[][][] dp = new boolean[itemCount + 1][n][m]; // A < n, B < m
        dp[0][0][0] = true;

        for (int i = 0; i < itemCount; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!dp[i][a][b]) continue;

                    // A가 훔치는 경우
                    if (a + aTrace < n) {
                        dp[i + 1][a + aTrace][b] = true;
                    }

                    // B가 훔치는 경우
                    if (b + bTrace < m) {
                        dp[i + 1][a][b + bTrace] = true;
                    }
                }
            }
        }

        // 마지막 단계에서 A의 최소 흔적 찾기
        int minATrace = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[itemCount][a][b]) {
                    minATrace = Math.min(minATrace, a);
                }
            }
        }

        return minATrace == Integer.MAX_VALUE ? -1 : minATrace;
    }
}