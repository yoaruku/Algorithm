import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");
        HashSet<Integer> Arr1 = new HashSet<>();
        for (int i = 0 ; i < n; i++){
            Arr1.add(Integer.parseInt(arr1[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");

        for (String str2 : arr2){
            boolean tf = Arr1.contains(Integer.parseInt(str2));
            System.out.println(tf? 1 : 0);
        }
    }
}
