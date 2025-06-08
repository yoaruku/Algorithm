
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) * 3;
        int M = Integer.parseInt(st.nextToken()) * 8;

        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++){
            String input = br.readLine();
            for (int j = 0 ; j < M; j++){
                arr[i][j] = input.charAt(j);
            }
        }

        for (int i = 1; i < N; i+=3){
            for (int k = 0; k < M; k+=8) {
                int a = arr[i][k+1] - '0';
                int b = arr[i][k+3] - '0';
                int c;

                boolean two = false;
                if (Character.isDigit(arr[i][k+6])) {
                    c = (arr[i][k+5] - '0') * 10 + (arr[i][k+6] - '0');
                    two = true;
                } else {
                    c = arr[i][k+5] - '0';
                }

                if (a + b == c) {
                    arr[i][k+0] = '*';
                    if (two && k+7 < M) {
                        for (int j = 1; j <= 6; j++) {
                            arr[i - 1][k+j] = '*';
                            arr[i + 1][k+j] = '*';
                        }
                        arr[i][k+7] = '*';
                    } else {
                        for (int j = 1; j < 6; j++) {
                            arr[i - 1][k+j] = '*';
                            arr[i + 1][k+j] = '*';
                        }
                        arr[i][k+6] = '*';
                    }
                } else {
                    arr[i + 1][k+1] = '/';
                    arr[i][k+2] = '/';
                    arr[i - 1][k+3] = '/';
                }
            }
        }

        for (int i = 0 ; i < N; i++){
            for (int j = 0; j < M; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
