import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0 ; i < n; i++){
            String input = br.readLine();
            set.add(input);
            StringBuffer sb = new StringBuffer(input);
            if(set.contains(sb.reverse().toString())){
                System.out.println(
                        input.length() + " " + input.charAt(input.length()/2)
                );
                break;
            }
        }
    }
}
