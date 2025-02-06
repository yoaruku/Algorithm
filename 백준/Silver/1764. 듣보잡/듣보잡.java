import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] idx = br.readLine().split(" ");
        int n = Integer.parseInt(idx[0]) + Integer.parseInt(idx[1]);

        Map<String, Integer> nameList = new TreeMap<String, Integer>();


        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            nameList.put(name, nameList.getOrDefault(name, 0) + 1);
        }

        System.out.println(nameList.values()
                                   .stream()
                                   .filter(value -> value > 1)
                                   .count()
        );
        
        for (Map.Entry<String, Integer> entry : nameList.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}