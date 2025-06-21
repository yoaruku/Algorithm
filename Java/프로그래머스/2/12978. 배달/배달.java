import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) 
            graph[i] = new ArrayList<>();

        for (int[] r : road) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]}); // 양방향
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0}); // {노드, 비용}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int now = current[0];
            int cost = current[1];

            if (dist[now] < cost) continue;

            for (int[] next : graph[now]) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (dist[nextNode] > dist[now] + nextCost) {
                    dist[nextNode] = dist[now] + nextCost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }
        return count;
    }
}