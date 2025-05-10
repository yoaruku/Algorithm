import java.util.Stack;

class Solution {
    public static int solution(int[] number) {
        return counting(number, new Stack<>(), 0);
    }

    public static int counting(int[] number, Stack<Integer> stack, int idx) {

        if (stack.size() == 3) {

            if (stack.stream().mapToInt(Integer::intValue).sum() == 0) {
                return 1;
            }
            return 0;

        }
        int result = 0;

        for (int i = idx; i < number.length; i++) {
            stack.push(number[i]);
            result += counting(number, stack, i+1);
            stack.pop();
        }

        return result;
    }
}