import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        boolean asc = true;
        boolean des = true;
        
        int prev = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()){
            int curr = Integer.parseInt(st.nextToken());
            
            if (prev - curr != 1){
                des = false;
            }
            if (prev - curr != -1){
                asc = false;
            }
            
            if (!des && !asc){
                break;
            }
            prev = curr;
        }

        System.out.println(
                asc? "ascending" : des ? "descending" : "mixed"
        );
    }
}
