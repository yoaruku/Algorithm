import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static List<Integer> cards;
    public static int M;
    public static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        cards = new ArrayList<>(M);

        for (String str : input){
            cards.add(Integer.parseInt(str));
        }

        Stack<Integer> select = new Stack<>();

        brute(select, 0);

        System.out.println(result);
    }

    public static void brute(Stack<Integer> select, int idx){
        if (select.size() == 3){
            int sum = select.stream().mapToInt(Integer::intValue).sum();

            if (sum <= M){
                result = Math.max(result, sum);
            }

            return;
        }

        for(int i = idx; i < cards.size(); i++){
            select.push(cards.get(i));
            brute(select, i+1);
            select.pop();
        }
    }
}
