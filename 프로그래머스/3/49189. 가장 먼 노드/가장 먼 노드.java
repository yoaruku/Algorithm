import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] e : edge) {
            Set<Integer> list = map.getOrDefault(e[0], new HashSet<>());
            list.add(e[1]);
            map.put(e[0], list);

            list = map.getOrDefault(e[1], new HashSet<>());
            list.add(e[0]);
            map.put(e[1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int count = 0;
        int[] visited = new int[n+1];
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : map.get(cur)) {
                if (visited[next] == 0 && !queue.contains(next)) {
                    queue.add(next);
                    visited[next] = visited[cur]+1;
                }
            }
        }

        int finalCount = Arrays.stream(visited).max().orElse(0);
        return (int) Arrays.stream(visited).filter(num -> num == finalCount).count();
    }
}