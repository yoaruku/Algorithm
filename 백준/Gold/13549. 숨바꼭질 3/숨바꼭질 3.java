import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = 5;
        int K = 17;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        String[] nk = br.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);

        System.out.println(solution(N, K));

    }

    public static int solution(int N, int K) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node init = new Node(N, 0);
        pq.add(init);

        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()){

            Node node = pq.poll();

            if (node.sec < visited.getOrDefault(node.index, Integer.MAX_VALUE)) {
                visited.put(node.index, node.sec);
            } else {
                continue;
            }

            if (node.index <= 500000){
                pq.offer(new Node(node.index*2, node.sec));
            }
            if (node.index > 0){
                pq.offer(new Node(node.index-1, node.sec+1));
            }
            if (node.index < 1000000){
                pq.offer(new Node(node.index+1, node.sec+1));
            }
        }

        return visited.get(K);
    }

    public static class Node implements Comparable<Node>{
        int index;
        int sec;

        public Node(int index, int sec) {
            this.index = index;
            this.sec = sec;
        }

        @Override
        public int compareTo(Node o) {
            return sec - o.sec;
        }
    }
}
