import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i < M; i++){

            st = new StringTokenizer(br.readLine());
            graph.add(new Edge(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));

        }

        for (int i = 0; i < N; i++){

            for (int j = 0; j < M; j++){

                Edge edge = graph.get(j);
                if (dist[edge.from] != Integer.MAX_VALUE){
                    dist[edge.to] = Long.min(dist[edge.to], dist[edge.from] + edge.cost);
                }
            }
        }

        for (int j = 0; j < M; j++){

            Edge edge = graph.get(j);
            if (dist[edge.from] != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost){
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i < dist.length; i++){
            if (dist[i] != Integer.MAX_VALUE){
                System.out.println(dist[i]);
            } else {
                System.out.println("-1");
            }
        }
    }

    public static class Edge{
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
