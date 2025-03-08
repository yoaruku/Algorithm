
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static class Work{
        int end;
        int point;
        int now;

        Work(int end, int point){
            this.end = end;
            this.now = 1;
            this.point = point;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        Stack<Work> stack = new Stack<>();

        int point = 0;

        for (int i = 0 ; i < loop; i++){
            String[] input = br.readLine().split(" ");

            if (input[0].equals("0")){
                if (!stack.empty()){
                    Work current = stack.pop();
                    current.now++;

                    stack.push(current);
                }
            }

            if (input[0].equals("1")){
                int newPoint = Integer.parseInt(input[1]);
                int newEnd = Integer.parseInt(input[2]);
                Work newWork = new Work(newEnd, newPoint);

                stack.push(newWork);
            }

            while (!stack.empty() && stack.peek().now == stack.peek().end) {
                point += stack.pop().point;
            }
        }

        System.out.println(point);
    }
}
