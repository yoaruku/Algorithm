import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);  // 기차 개수
        int m = Integer.parseInt(input[1]);  // 명령 개수

        int[][] train = new int[n][20];  // 각 기차는 20개의 좌석을 가짐

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int trainIdx = Integer.parseInt(input[1]) - 1;  // 1-based → 0-based index 변환

            if (input[0].equals("1")) {
                enter(train[trainIdx], Integer.parseInt(input[2]));
            } else if (input[0].equals("2")) {
                exit(train[trainIdx], Integer.parseInt(input[2]));
            } else if (input[0].equals("3")) {
                back(train[trainIdx]);
            } else if (input[0].equals("4")) {
                front(train[trainIdx]);
            }
        }

        // HashSet을 이용하여 고유한 기차 상태 개수 세기
        Set<String> uniqueTrains = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueTrains.add(Arrays.toString(train[i]));
        }

        System.out.println(uniqueTrains.size());
    }

    // 탑승
    public static void enter(int[] train, int x) {
        train[x - 1] = 1;  // 1-based → 0-based index 변환
    }

    // 하차
    public static void exit(int[] train, int x) {
        train[x - 1] = 0;  // 1-based → 0-based index 변환
    }

    // 뒤로 한 칸 이동 (맨 뒤는 0으로)
    public static void back(int[] train) {
        for (int i = train.length - 1; i >= 1; i--) {
            train[i] = train[i - 1];
        }
        train[0] = 0; // 첫 번째 좌석 초기화
    }

    // 앞으로 한 칸 이동 (맨 앞은 0으로)
    public static void front(int[] train) {
        for (int i = 0; i < train.length - 1; i++) {
            train[i] = train[i + 1];
        }
        train[train.length - 1] = 0; // 마지막 좌석 초기화
    }
}
