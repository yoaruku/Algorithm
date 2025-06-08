
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int left = 0;
        int right = 0;
        int top = 0;
        int bot = 0;

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0 ; i < N; i++){
            String input = br.readLine();
            for (int j = 0 ; j < N; j++){
                if(input.charAt(j) == 'G'){
                    left = Math.max(left, j);
                    right = Math.max(right, N-1-j);
                    top = Math.max(top, N-1-i);
                    bot = Math.max(bot, i);
                    row.add(i);
                    col.add(j);
                }
            }
        }

        int min = Math.min(left+top, Math.min(left+bot, Math.min(right+top,right+bot)));

        if (row.size() <= 1){
            min = Math.min(right, left);
        }

        if (col.size() <= 1){
            min = Math.min(top, bot);
        }

        if (row.size() == 1 && col.size() == 1){
            min = 0;
        }

        System.out.println(min);

    }
}
