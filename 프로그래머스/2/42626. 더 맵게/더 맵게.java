import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        Arrays.stream(scoville).forEach(pq::add);

        while (pq.size() > 1 && pq.peek() < K) {
            pq.add(pq.poll() + pq.poll() * 2);
            count++;
        }

        return pq.peek() < K ? -1 : count;
    }
}