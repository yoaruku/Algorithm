import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

    public static Stack<Integer> nanjang = new Stack<>();
    public static List<Integer> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 9; i++){
            String input = br.readLine();

            if (input.isEmpty())
                break;

            people.add(Integer.parseInt(input));
        }

        Collections.sort(people);

        brute(0);
    }

    public static void brute(int idx){

        if (nanjang.size() == 7){

            int sum = nanjang.stream().mapToInt(Integer::intValue).sum();

            if (sum == 100){
                for (int num : nanjang) {
                    System.out.println(num);
                }
                System.exit(0); // 정답 찾으면 종료
            }
        }

        for (int i = idx; i < people.size(); i++){
            nanjang.push(people.get(i));
            brute(i+1);
            nanjang.pop();
        }
    }
}
