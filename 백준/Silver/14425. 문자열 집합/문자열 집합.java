import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
        String[] nIdx = br.readLine().split(" ");
        int[] idx = {Integer.parseInt(nIdx[0]), Integer.parseInt(nIdx[1])};

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < idx[0]; i++) {
            String str = br.readLine();

            map.put(str,0);
        }

        for (int i = 0; i < idx[1]; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                map.put(str,map.get(str)+1);
            }
        }

        System.out.println(map.values()
                                   .stream()
                                   .filter( value -> value > 0)
                                   .mapToInt(Integer::intValue)
                                   .sum()
        );

    }

}
