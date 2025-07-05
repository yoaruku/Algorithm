import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++){
            pQue.offer(priorities[i]);
        }

        int count = 1;
        int idx = 0;

        int curr = pQue.poll();
        while (!pQue.isEmpty()){
            
            if (curr == priorities[idx]){
                
                priorities[idx] = -1;
                
                if (idx == location)
                    break;
                
                curr = pQue.poll();
                count++;
            }
            
            idx = (idx + 1) % priorities.length;
        }
        
        return count;
    }
}