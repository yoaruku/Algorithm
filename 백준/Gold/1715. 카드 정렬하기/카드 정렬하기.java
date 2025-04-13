import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i ++){
            queue.offer(Integer.parseInt(br.readLine()));
        }

        Integer result = 0;

        while (!queue.isEmpty()){
            if (queue.size() <= 1){
                break;
            }

            Integer sum = queue.poll() + queue.poll();
            result += sum;
            queue.offer(sum);
        }

        System.out.println(result);
    }
}
