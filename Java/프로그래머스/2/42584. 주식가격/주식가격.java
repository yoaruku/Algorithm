import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] time = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // 가격이 떨어진 경우
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                time[j] = i - j;
            }
            stack.push(i);
        }

        // 가격이 끝까지 떨어지지 않은 경우 처리
        while (!stack.isEmpty()) {
            int j = stack.pop();
            time[j] = prices.length - 1 - j;
        }

        return time;
        
    }
}