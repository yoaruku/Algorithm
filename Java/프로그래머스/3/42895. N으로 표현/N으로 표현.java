import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<HashSet<Integer>> result = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            result.add(new HashSet<>());
        }

        // 초기값
        result.get(0).add(N);

        for (int i = 1; i < 8; i++) {
            HashSet<Integer> temp = result.get(i);

            // N을 i+1번 사용하여 만든 숫자 추가
            temp.add(initNum(N, i + 1));

            // 이전 집합 조합 계산
            for (int j = 0; j < i; j++) {
                for (Integer num1 : result.get(j)) {
                    for (Integer num2 : result.get(i - j - 1)) {
                        temp.add(num1 + num2);
                        temp.add(num1 - num2);
                        temp.add(num1 * num2);
                        if (num2 != 0) {
                            temp.add(num1 / num2);
                        }
                    }
                }
            }

            // 목표 숫자 찾기
            if (temp.contains(number)) {
                return i + 1;
            }
        }

        return -1; // 8번을 초과하면 불가능
    }

    // N을 이어붙인 숫자 계산
    public Integer initNum(int N, int idx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append(N);
        }
        return Integer.parseInt(sb.toString());
    }
}
