import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        int result = 0;

        for (int i = 0 ; i < N; i++){
            String input = br.readLine();

            if (!input.equals("ENTER")){
                set.add(input);
            }

            if(input.equals("ENTER")){
                result += set.size();
                set.clear();
            }
        }

        result += set.size();

        System.out.println(result);
    }
}
