import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static class People implements Comparable<People>{
        int idx;
        int vote;

        People(int idx, int vote){
            this.idx = idx;
            this.vote = vote;
        }

        @Override
        public int compareTo(People o) {

            if (this.vote == o.vote)
                return this.idx - o.idx;  // 득표 수가 같다면 인덱스 기준 오름차순
            return o.vote - this.vote;    // 득표 수 기준 내림차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<People> queue = new PriorityQueue<>();

        int dasomInput = Integer.parseInt(br.readLine());
        People dasom = new People(0, dasomInput);

        for (int i = 1; i < n; i++) {
            int vote = Integer.parseInt(br.readLine());
            queue.offer(new People(i, vote));
        }

        int count = 0;
        while (!queue.isEmpty() && queue.peek().vote >= dasom.vote) {
            People people = queue.poll();
            people.vote--;
            dasom.vote++;
            count++;
            queue.offer(people);
        }

        System.out.println(count);
    }
}
