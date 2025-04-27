import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<Integer> fanNode = new HashSet<>();
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static boolean meet = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);


        for (int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int nextNode = Integer.parseInt(input[1]);

            Set<Integer> set = map.getOrDefault(node, new HashSet<>());
            set.add(nextNode);

            map.put(node, set);
        }

        int fan = Integer.parseInt(br.readLine());

        input = br.readLine().split(" ");

        for (String str : input){
            fanNode.add(Integer.parseInt(str));
        }

        if (!fanNode.contains(1)){
            go(map.get(1));
        }

        System.out.println(meet ? "yes" : "Yes");
    }

    public static void go(Set<Integer> set){

        if (set == null || set.isEmpty()){
            meet = true;
            return;
        }

        for (Integer nextNode : set){
            if (!fanNode.contains(nextNode)){
                go(map.get(nextNode));
            }
        }
    }
}
