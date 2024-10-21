import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // Index 번호를 담을 스택 선언
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (; i < arr.length-1; i++) {
            
            // 다음 번호와 값이 다르다면 stack에 Index 저장
            if (arr[i] != arr[i+1]) {
                stack.add(i);
            }
        }

        // 배열의 마지막 숫자와 stack에 담긴 마지막 Index의 숫자가 다르면 stack에 Index추가
        if (stack.isEmpty() || arr[i] != arr[stack.peek()]) {
            stack.add(i);
        }

        // 결과 배열 선언
        int[] answer = new int[stack.size()];
        
        // LIFO 이므로 역순으로 저장
        for (i = stack.size()-1 ; i >= 0 ; i--){
            answer[i] = arr[stack.pop()];
        }

        return answer;
    }
}