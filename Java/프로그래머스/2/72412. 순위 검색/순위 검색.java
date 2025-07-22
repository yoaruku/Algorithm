import java.util.*;

class Solution {
    static Map<String, List<Integer>> infoMap = new HashMap<>();

    public static int[] solution(String[] info, String[] query) {
        for (String i : info) {
            String[] parts = i.split(" ");
            String[] keys = new String[]{parts[0], parts[1], parts[2], parts[3]};
            int score = Integer.parseInt(parts[4]);

            makeCombinations(keys, 0, "", score);
        }

        // 점수 리스트를 오름차순 정렬
        for (List<Integer> scores : infoMap.values()) {
            Collections.sort(scores);
        }

        List<Integer> result = new ArrayList<>();

        for (String q : query) {
            String cleaned = q.replaceAll(" and ", " ");
            String[] parts = cleaned.split(" ");
            String key = parts[0] + parts[1] + parts[2] + parts[3];
            int targetScore = Integer.parseInt(parts[4]);

            if (infoMap.containsKey(key)) {
                List<Integer> scores = infoMap.get(key);
                int idx = lowerBound(scores, targetScore);
                result.add(scores.size() - idx);
            } else {
                result.add(0);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // 가능한 모든 조합을 Map에 저장
    public static void makeCombinations(String[] keys, int depth, String current, int score) {
        if (depth == 4) {
            infoMap.computeIfAbsent(current, k -> new ArrayList<>()).add(score);
            return;
        }

        makeCombinations(keys, depth + 1, current + keys[depth], score);
        makeCombinations(keys, depth + 1, current + "-", score);
    }

    // 이진 탐색으로 기준 점수 이상인 사람의 수 찾기
    public static int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}