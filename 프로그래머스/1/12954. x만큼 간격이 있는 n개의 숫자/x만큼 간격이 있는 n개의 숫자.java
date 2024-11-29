import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        List<Long> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            result.add((long) x * i);
        }

        return result.stream().mapToLong(Long::valueOf).toArray();
    }
}