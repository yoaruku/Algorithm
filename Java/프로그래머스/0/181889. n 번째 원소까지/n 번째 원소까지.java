import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < n; i++)
            list.add(num_list[i]);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}