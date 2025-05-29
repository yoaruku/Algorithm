import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int count = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < players.length; i++){
            
            while (!queue.isEmpty() && queue.peek() <= i){
               queue.poll();
            }
            
            if (players[i] >= queue.size()*m ){
                int diff = (players[i]/m) - queue.size();
                count += diff;
                for (int j = 0 ; j < diff; j++){
                    queue.add(i+k);
                }
            }
        }
        
        return count;
    }
}