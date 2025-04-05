import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int round = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int M = 0;
        int N = 0;

        int[] result = new int[n];

        for (int i = 0 ; i < n; i++){
            String[] input = br.readLine().split(" ");

            M  = Integer.parseInt(input[0]);
            N  = Integer.parseInt(input[1]);

            if (M == N){
                result[i] = 1;
            }

            if (M > N){
                if (Math.abs(M-N) - (round - Math.max(M,N)) <= 2){
                    result[i] = 1;
                }else{
                    result[i] = 0;
                }
            }

            if (M < N){
                if (Math.abs(M-N) - (round - Math.max(M,N)) <= 1){
                    result[i] = 1;
                }else{
                    result[i] = 0;
                }
            }
        }

        for (int k : result){
            System.out.println(k);
        }
    }
}
