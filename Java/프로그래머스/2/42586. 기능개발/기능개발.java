import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = 0;
            int time = 0;

            while (progress < 100) {
                progress = progresses[i] + (speeds[i] * ++time);
            }

            queue.add(time);
        }

        int baepo = queue.peek();
        int count = 0;
        while (!queue.isEmpty()) {

            if (queue.peek() <= baepo) {
                queue.poll();
                count++;
            }else{
                result.add(count);
                baepo = queue.peek();
                count = 0;
            }

            if (queue.isEmpty()) {
                result.add(count);
            }

        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}