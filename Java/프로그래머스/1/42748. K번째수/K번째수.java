import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> list = new ArrayList<>();

        for( int[] command : commands){

            int[] newArr = Arrays.copyOfRange(array, command[0]-1, command[1]);

            Arrays.sort(newArr);

            System.out.println(Arrays.toString(newArr));
            list.add(newArr[command[2]-1]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}