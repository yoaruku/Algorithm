import java.util.*;

class Solution {
    public long solution(long n) {
        long result = 0;

        List<Long> list = new ArrayList<>();

        while (n > 0){
            list.add(n % 10);
            n /= 10;
        }

        list.sort(Collections.reverseOrder());

        for (Long num : list){
            result = result * 10 + num;
        }

        return result;
    }
}