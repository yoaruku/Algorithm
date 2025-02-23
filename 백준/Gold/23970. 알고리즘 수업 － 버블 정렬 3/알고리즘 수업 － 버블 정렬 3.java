import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        if( Arrays.equals(a, b)){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n-1; i++){
            boolean swaped = false;

            second:
            for (int j = 0; j < n-1-i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swaped = true;

                    if( a[j] == b[j] ) {
                        if (Arrays.equals(a, b)) {
                            System.out.println(1);
                            return;
                        }
                    }
                }
            }

            if (!swaped){
                break;
            }
        }

        System.out.println(0);
    }
}