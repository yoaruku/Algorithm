import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); 

        for (char c = 'a'; c <= 'z'; c++){
            System.out.print(str.indexOf(c)+" ");
        }
    }
}
