import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Set<Integer>> nodes = new HashMap<>();

        for (int i = 0 ; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            Set<Integer> child = nodes.getOrDefault(left, new HashSet<>());
            child.add(right);
            nodes.put(left,child);

            child = nodes.getOrDefault(right, new HashSet<>());
            child.add(left);
            nodes.put(right,child);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] parents = new int[n+1];
        boolean[] visited = new boolean[n];
        queue.add(1);
        visited[0] = true;

        while (!queue.isEmpty()){
            int parent = queue.poll();
            visited[parent-1] = true;

            Set<Integer> child = nodes.get(parent);
            if (child == null)
                continue;

            for (Integer num : child){

                if (parents[num] == 0){
                    parents[num] = parent;
                }

                if (!visited[num-1]){
                    queue.add(num);
                }
            }
        }

        for (int i = 2; i < n+1; i++){
            System.out.println(parents[i]);
        }
    }
}
