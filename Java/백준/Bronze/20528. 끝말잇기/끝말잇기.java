import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n ; i++){
            list.add(input[i]);
        }

        Collections.sort(list);

        int result = 0;

        if (list.get(0).charAt(0) == list.get(list.size()-1).charAt(0)){
            result = 1;
        }

        System.out.println(result);
    }
}
