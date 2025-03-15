import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] train = new int[n][20];

        for (int i = 0 ; i < m; i++){
            input = br.readLine().split(" ");

            if (input[0].equals("1"))
                enter(train[Integer.parseInt(input[1])-1], Integer.parseInt(input[2]));

            if (input[0].equals("2"))
                exit(train[Integer.parseInt(input[1])-1], Integer.parseInt(input[2]));

            if (input[0].equals("3"))
                back(train[Integer.parseInt(input[1])-1]);

            if (input[0].equals("4"))
                front(train[Integer.parseInt(input[1])-1]);
        }

        // HashSet을 사용하여 고유한 기차 상태를 저장
        Set<String> uniqueTrains = new HashSet<>();

        for (int i = 0; i < n; i++) {
            uniqueTrains.add(Arrays.toString(train[i])); // 배열을 문자열로 변환하여 저장
        }

        System.out.println(uniqueTrains.size()); // 고유한 기차 상태 개수 출력
    }

    public static void enter(int[] train, int x){
        train[x-1] = 1;
    }

    public static void exit(int[] train, int x){
        train[x-1] = 0;
    }

    public static void back(int[] train){
        for (int i = train.length-1 ; i >= 1; i--){
            train[i] = train[i-1];
        }
        train[0] = 0;  // 첫 번째 칸을 0으로 초기화
    }

    public static void front(int[] train){
        for (int i = 0 ; i <train.length-1; i++){
            train[i] = train[i+1];
        }
        train[train.length - 1] = 0;  // 마지막 칸을 0으로 초기화
    }
}
