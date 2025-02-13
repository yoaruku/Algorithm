import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < idx; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        int max = 0;
        String result = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey(); // 최댓값 갱신 시 result 변경
            } else if (entry.getValue() == max) {
                if (result.compareTo(entry.getKey()) > 0) { // 사전순 비교
                    result = entry.getKey();
                }
            }
        }

        System.out.println(result);
    }
}