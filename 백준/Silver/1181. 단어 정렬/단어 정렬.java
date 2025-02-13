import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = Integer.parseInt(br.readLine());

        SortedSet<String> set = new TreeSet<>(
                Comparator.comparingInt(String::length)
                        .thenComparing(String::compareTo)
        );

        for (int i = 0; i < idx; i++) {
            set.add(br.readLine());
        }

        for (String s : set) {
            System.out.println(s);
        }

    }
}
