import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int[] query : queries){
            
            int min = Integer.MAX_VALUE;
            for(int i = query[0]; i <= query[1]; i++){
                if(arr[i] > query[2]){
                    min = Math.min(min, arr[i]);
                }
            }
            
            if(min == Integer.MAX_VALUE){
                min = -1;
            }
            
            list.add(min);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}