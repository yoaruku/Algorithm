import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();

        for (int num : arr){
            boolean tf = true;
            for (int i = 0 ; i < delete_list.length; i++){
                if (delete_list[i] == num) {
                    tf = false;
                    break;
                }
            }

            if (tf)
                list.add(num);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}