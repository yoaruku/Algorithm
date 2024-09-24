import java.util.HashSet;
import java.util.Set;

class Solution {
    
    public int solution(int[] nums) {
        
       Set<Integer> list = new HashSet<>();
        
        for ( int idx : nums ){
            list.add(idx);
        }

        if (list.size() > nums.length / 2){
            return nums.length / 2;
        } else {
            return list.size();
        }
    }
}