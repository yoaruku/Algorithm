class Solution {
    public int solution(int n, int[][] results) {
        int[][] result = new int[n+1][n+1];

        for (int[] arr : results){
            result[arr[0]][arr[1]] = 1;
            result[arr[1]][arr[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (result[i][j] == 1) {
                    for (int k = 1; k <= n; k++) {
                        if ( result[j][k] == 1){
                            result[i][k] = 1;
                            result[k][i] = -1;
                        }
                    }
                }

                if (result[i][j] == -1) {
                    for (int k = 1; k <= n; k++) {
                        if ( result[j][k] == -1){
                            result[i][k] = -1;
                            result[k][i] = 1;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int N = 0;

            for (int j = 1; j <= n; j++) {
                if(result[i][j] != 0){
                    N++;
                }
            }

            if(N == n-1){
                count++;
            }
        }

        return count;
    }
}