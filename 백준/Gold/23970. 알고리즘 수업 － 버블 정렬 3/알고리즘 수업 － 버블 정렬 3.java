import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        if ( a.equals(b) ){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n-1; i++){
            boolean swaped = false;

            second:
            for (int j = 0; j < n-1-i; j++) {
                if (a.get(j) > a.get(j+1)) {
                    int temp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, temp);
                    swaped = true;

                    if(a.get(j).equals(b.get(j))) {
                        if( a.equals(b) ) {
                            System.out.println(1);
                            return;
                        }
                    }
                }
            }

            if (!swaped){
                break;
            }
        }

        System.out.println(0);
    }
}
