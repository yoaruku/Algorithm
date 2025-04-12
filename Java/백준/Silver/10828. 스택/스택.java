import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("push")) {
                stack.add(Integer.parseInt(input[1]));
            }
            if (input[0].equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            }
            if (input[0].equals("size")) {
                System.out.println(stack.size());
            }
            if (input[0].equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
            if (input[0].equals("top")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
