import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> numberIndexStack = new Stack<>();
        numberIndexStack.add(0);
        
        for(int i = 1; i < numbers.length; i++) {
            
            while(!numberIndexStack.isEmpty() && 
                    numbers[i] > numbers[numberIndexStack.peek()]) {
                answer[numberIndexStack.pop()] = numbers[i];
            }
            
            numberIndexStack.add(i);
        }
        
        return answer;
    }
}