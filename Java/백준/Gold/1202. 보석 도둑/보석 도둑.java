import java.io.*;
import java.util.*;

public class Main {

    public static class Juwel implements Comparable<Juwel> {
        int weight;
        int price;

        Juwel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Juwel o) {
            return this.weight - o.weight;  // 무게 기준 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 보석 수
        int K = Integer.parseInt(input[1]); // 가방 수

        // 보석 입력 받기
        Juwel[] juwels = new Juwel[N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int price = Integer.parseInt(input[1]);
            juwels[i] = new Juwel(weight, price);
        }

        // 가방 입력 받기
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석은 무게 기준으로, 가방은 수용 무게 기준으로 정렬
        Arrays.sort(juwels);
        Arrays.sort(bags);

        // 최대 힙 (가치가 높은 순으로 저장)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long result = 0;
        int j = 0;

        // 각 가방에 대해 가능한 보석을 PQ에 넣고, 가장 가치 높은 보석 선택
        for (int i = 0; i < K; i++) {
            while (j < N && juwels[j].weight <= bags[i]) {
                pq.offer(juwels[j].price);
                j++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll(); // 가장 가치 높은 보석을 꺼내서 가방에 담음
            }
        }

        System.out.println(result);
    }
}
