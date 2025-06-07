import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2 ; i <= n+1; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        if (n == 1 || n == 2)
            System.out.println(1);
        else
            System.out.println(arr[n]);
    }
}
