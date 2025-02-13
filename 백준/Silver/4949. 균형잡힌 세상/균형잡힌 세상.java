import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String str = br.readLine();

            if (str.equals(".")){
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean tf = true;

            for (char c : str.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                }
                if (c == '[') {
                    stack.push(c);
                }
                if (c == ')') {
                    if(stack.isEmpty() || !stack.peek().equals('(')){
                        tf = false;
                        break;
                    }
                    stack.pop();
                }
                if (c == ']') {
                    if(stack.isEmpty() || !stack.peek().equals('[')){
                        tf = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if( !stack.isEmpty() ){
                tf = false;
            }

            if (tf){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }
}
