import java.util.HashSet;
import java.util.Set;

class Solution {
    
    public int solution(int[] nums) {
        
       Set<Integer> list = new HashSet<>();
        
        for ( int idx : nums ){
            list.add(idx);
        }

        return list.size() > nums.length / 2 ? nums.length / 2 : list.size();
    }
}