import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();

        for (char c : number.toCharArray()){

            if (stack.isEmpty()){
                stack.push((int)c-48);
                continue;
            }

            while (k > 0 && !stack.isEmpty() && stack.peek() < (int) c -48){
                stack.pop();
                k--;
            }

            stack.push((int) c - 48);
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        
        for(Integer n : stack){
            sb.append(n);
        }

        return sb.toString();
    }
}