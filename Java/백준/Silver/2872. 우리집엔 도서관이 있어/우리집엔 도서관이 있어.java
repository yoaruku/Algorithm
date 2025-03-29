import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        
        Collections.reverse(list);
        
        int result = 0;
        int max = N;
        for (int i = 0 ; i < N; i++){
            if(list.get(i) == max){
                max--;
            }else{
                result++;
            }
        }

        System.out.println(result);
    }
}
