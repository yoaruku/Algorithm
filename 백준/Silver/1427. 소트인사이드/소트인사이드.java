
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<Integer> list = new ArrayList<>();

        for (char c : str.toCharArray()) {
            list.add(c-48);
        }

        list.sort(Collections.reverseOrder());

        for (Integer i : list) {
            System.out.print(i);
        }
    }
}
