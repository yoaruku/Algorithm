import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Country implements Comparable<Country> {
        int num;
        int gold, silver, bronze;

        Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold != o.gold) return o.gold - this.gold;
            if (this.silver != o.silver) return o.silver - this.silver;
            return o.bronze - this.bronze;
        }

        public boolean eqMedal(Country o) {
            return this.gold == o.gold && this.silver == o.silver && this.bronze == o.bronze;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Country> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Country(num, gold, silver, bronze));
        }

        Collections.sort(list); // 메달 기준 내림차순 정렬

        Map<Integer, Integer> ranking = new HashMap<>();
        int rank = 1;
        ranking.put(list.get(0).num, rank);

        for (int i = 1; i < N; i++) {
            Country curr = list.get(i);
            Country prev = list.get(i - 1);

            if (curr.eqMedal(prev)) {
                ranking.put(curr.num, rank); // 같은 순위
            } else {
                rank = i + 1; // 등수는 현재 인덱스 + 1
                ranking.put(curr.num, rank);
            }
        }

        System.out.println(ranking.get(K));
    }
}
