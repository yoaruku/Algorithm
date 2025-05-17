import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static long[] dp;
    static int fib;
    static int fibo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        Arrays.fill(dp, -1);

        fib(n);
        fibonacci(n);
        System.out.println(fib+" "+fibo);

    }

    public static int fib(int n){
        if (n == 1 || n == 2){
            fib++;
            return 1;
        }else{
            return  (fib(n-1) + fib(n -2));
        }
    }

    public static long fibonacci(int n){

        if (dp[n] == -1 && n >= 3){
            dp[n] = fibonacci(n-1) + fibonacci(n-2);
            fibo++;
            return dp[n];
        } else{
            return dp[n];
        }
    }
}
