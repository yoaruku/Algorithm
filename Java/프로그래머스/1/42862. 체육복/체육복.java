import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);

        // 여벌도 있고 도난당한 사람 제거
        Set<Integer> intersection = new HashSet<>(lostSet);
        intersection.retainAll(reserveSet);
        lostSet.removeAll(intersection);
        reserveSet.removeAll(intersection);

        // 빌려줄 수 있는지 판단
        for (int r : reserveSet) {
            if (lostSet.contains(r - 1)) {
                lostSet.remove(r - 1);
            } else if (lostSet.contains(r + 1)) {
                lostSet.remove(r + 1);
            }
        }

        return n - lostSet.size();  // 남은 도난 수만큼 빼기
    }
}