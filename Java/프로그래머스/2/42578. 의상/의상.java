import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {

            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        int result = 1;
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result *= entry.getValue();
        }

        return result -1;
    }
}