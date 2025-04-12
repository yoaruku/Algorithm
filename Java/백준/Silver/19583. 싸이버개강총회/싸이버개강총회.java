import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime S = LocalTime.parse(input[0], df);
        LocalTime E = LocalTime.parse(input[1], df);
        LocalTime Q = LocalTime.parse(input[2], df);

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();

        String line;
        while ((line = br.readLine()) != null){
            input = line.split(" ");
            String time = input[0];
            String member = input[1];
            LocalTime lt = LocalTime.parse(time, df);
            if (lt.isAfter(Q)){
                break;
            }

            if (lt.isBefore(S) || lt.equals(S)){
                before.add(member);
            }

            if ((lt.isAfter(E) || lt.equals(E))
                    && (lt.isBefore(Q) || lt.equals(Q))){
                after.add(member);
            }
        }

        int count = 0;

        for (String member : before){
            if (after.contains(member))
                count++;
        }

        System.out.println(count);
    }
}
