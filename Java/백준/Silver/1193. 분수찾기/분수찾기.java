import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int sum = 0;
        int idx = 1;
        for (; idx <= target; idx++) {
            sum += idx;

            if (sum >= target) {
                break;
            }
        }

        int diff = sum - target;

        if ( idx % 2 == 1){
            System.out.println((1+diff)+"/"+(idx-diff));
        } else {
            System.out.println((idx-diff)+"/"+(1+diff));
        }
    }
}
