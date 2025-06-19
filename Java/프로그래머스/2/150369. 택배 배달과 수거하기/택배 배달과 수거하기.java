import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            Stack<Integer> delStack = new Stack<>();
            Stack<Integer> picStack = new Stack<>();

            // 뒤에서부터 0이 아닌 인덱스를 push
            for (int i = 0; i < n; i++) {
                if (deliveries[i] > 0) delStack.push(i);
                if (pickups[i] > 0) picStack.push(i);
            }

            long count = 0;
            while (!delStack.isEmpty() || !picStack.isEmpty()) {
                int maxDis = 0;
                int now = cap;

                // 배달 처리
                while (!delStack.isEmpty()) {
                    int idx = delStack.peek();
                    if (deliveries[idx] == 0) {
                        delStack.pop();
                        continue;
                    }
                    maxDis = Math.max(maxDis, idx + 1);
                    if (deliveries[idx] <= now) {
                        now -= deliveries[idx];
                        deliveries[idx] = 0;
                        delStack.pop();
                    } else {
                        deliveries[idx] -= now;
                        break;
                    }
                }

                now = cap;

                // 수거 처리
                while (!picStack.isEmpty()) {
                    int idx = picStack.peek();
                    if (pickups[idx] == 0) {
                        picStack.pop();
                        continue;
                    }
                    maxDis = Math.max(maxDis, idx + 1);
                    if (pickups[idx] <= now) {
                        now -= pickups[idx];
                        pickups[idx] = 0;
                        picStack.pop();
                    } else {
                        pickups[idx] -= now;
                        break;
                    }
                }

                count += 2L * maxDis;
            }

            return count;
        }
}