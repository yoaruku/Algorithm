import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] roadSpeed = new int[100]; // 전체 도로를 100km로 가정
        int[] carSpeed = new int[100];

        // 도로 제한 속도 설정
        int pos = 0;
        for (int i = 0; i < n; i++) {
            String[] gets = br.readLine().split(" ");
            int length = Integer.parseInt(gets[0]);
            int speedLimit = Integer.parseInt(gets[1]);

            for (int j = 0; j < length; j++) {
                roadSpeed[pos++] = speedLimit;
            }
        }

        // 차량 이동 속도 설정
        pos = 0;
        for (int i = 0; i < m; i++) {
            String[] gets = br.readLine().split(" ");
            int length = Integer.parseInt(gets[0]);
            int speed = Integer.parseInt(gets[1]);

            for (int j = 0; j < length; j++) {
                carSpeed[pos++] = speed;
            }
        }

        // 최대 속도 초과 구하기
        int maxOverSpeed = 0;
        for (int i = 0; i < 100; i++) {
            maxOverSpeed = Math.max(maxOverSpeed, carSpeed[i] - roadSpeed[i]);
        }

        System.out.println(maxOverSpeed);
    }
}