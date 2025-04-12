import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i ++){
            queue.offer(Long.parseLong(br.readLine()));
        }

        Long result = 0L;

        while (!queue.isEmpty()){
            if (queue.size() <= 1){
                break;
            }

            Long sum = queue.poll() + queue.poll();
            result += sum;
            queue.offer(sum);
        }

        System.out.println(BigInteger.valueOf(result));
    }
}
