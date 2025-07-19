import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] weight = new int[n];
        int[] tall = new int[n];

        StringTokenizer st;
        for (int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());

            weight[i] = Integer.parseInt(st.nextToken());
            tall[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            int count = 1;
            for (int j = 0; j < n; j++){

                if (i == j)
                    continue;

                if (weight[i] < weight[j] && tall[i] < tall[j]){
                    count++;
                }
            }

            result[i] = count;
        }

        StringBuilder sb = new StringBuilder();
        for (int c : result){
            sb.append(c +" ");
        }

        System.out.println(sb);
    }
}
