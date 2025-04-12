import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static class AbsNum implements Comparable<AbsNum>{
        int num;

        AbsNum(int num){
            this.num = num;
        }

        @Override
        public int compareTo(AbsNum o) {
            int abs1 = Math.abs(this.num);
            int abs2 = Math.abs(o.num);

            if (abs1 != abs2) {
                return abs1 - abs2; // 절댓값이 작은 수 우선
            } else {
                return this.num - o.num; // 절댓값 같으면 실제 값이 작은 수 우선
            }
        }

        @Override
        public String toString() {
            return String.valueOf(num);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<AbsNum> queue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if (num != 0){
                queue.offer(new AbsNum(num));
            }

            if (num == 0){
                if (!queue.isEmpty()){
                    sb.append(queue.poll().toString()+"\n");
                }else{
                    sb.append("0\n");
                }
            }
        }

        System.out.println(sb);
    }
}
