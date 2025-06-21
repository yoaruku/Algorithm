import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean[][] dohwaji = new boolean[100][100];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x+10; j++){
                for (int k = y; k < y+10; k++){

                    if (j >= 100 || k >= 100){
                        continue;
                    }
                    dohwaji[j][k] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0 ; i < 100; i++){
            for (int j=0; j < 100; j++){
                if (dohwaji[i][j])
                    count++;
            }
        }

        System.out.println(count);
    }
}
