import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int num : arr) {
            if (num % divisor == 0) {
                pq.add(num);
            }
        }
        
        while ( !pq.isEmpty() ) {
            result.add(pq.poll());
        }

        return !result.isEmpty() ? result.stream().mapToInt(i -> i).toArray() : new int[]{-1};
    }
}