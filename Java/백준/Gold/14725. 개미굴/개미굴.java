import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node {
        int depth;
        String current;
        TreeMap<String, Node> sons;

        Node(int depth, String current) {
            this.depth = depth;
            this.current = current;
            this.sons = new TreeMap<>();
        }

        public void addSon(String name, Node son) {
            this.sons.put(name, son);
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.depth; i++) {
                sb.append("--");
            }
            sb.append(this.current);
            System.out.println(sb);

            for (Node child : sons.values()) {
                child.print();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node root = new Node(-1, "ROOT");

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int depth = Integer.parseInt(parts[0]);

            Node curr = root;
            for (int j = 1; j <= depth; j++) {
                String name = parts[j];
                if (!curr.sons.containsKey(name)) {
                    curr.sons.put(name, new Node(j - 1, name));
                }
                curr = curr.sons.get(name);
            }
        }

        for (Node node : root.sons.values()) {
            node.print();
        }
    }
}
