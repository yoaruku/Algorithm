import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine()); // 게이트 수
        int P = Integer.parseInt(br.readLine()); // 비행기 수

        parent = new int[G + 1];

        // 초기에는 각 게이트가 자기 자신을 부모로 가짐
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int count = 0;

        for (int i = 0; i < P; i++) {
            int plane = Integer.parseInt(br.readLine());
            int availableGate = find(plane);

            if (availableGate == 0) { // 0번은 게이트 없음 = 도킹 불가
                break;
            }

            // 도킹 성공: 현재 게이트의 부모를 바로 왼쪽 게이트로 갱신
            union(availableGate, availableGate - 1);
            count++;
        }

        System.out.println(count);
    }

    // Find 함수: 현재 노드의 부모를 재귀적으로 찾아 경로 압축
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    // Union 함수: x의 부모를 y로 변경
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[x] = y;
    }
}
