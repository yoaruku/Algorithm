import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 줄 입력 처리
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> cats = new ArrayList<>();

        // 두 번째 줄 입력 처리
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cats.add(Integer.parseInt(st.nextToken()));
        }

        // 고양이 무게를 정렬
        cats.sort(Integer::compareTo);

        // 투포인터 설정
        int left = 0;
        int right = n - 1;
        int cnt = 0;

        // 투포인터를 사용하여 두 수의 합이 k인 쌍 찾기
        // 틀렸음 !!! K이하인것 찾기임 멍텅구리
        while (left < right) {
            int sum = cats.get(left) + cats.get(right);

            if (sum <= k) {
                cnt++;
                left++;
                right--;
            } else {
                right--;
            }
        }

        // 결과 출력
        System.out.println(cnt);
    }
}
