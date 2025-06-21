import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long result = cal(N,M);

            System.out.println(result);
        }


    }

    public static long cal(int N, int M){
        return factorial(M)
                .divide(factorial(N).multiply(factorial(M - N)))
                .longValue();
    }



    public static BigInteger factorial(int N){
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= N; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
