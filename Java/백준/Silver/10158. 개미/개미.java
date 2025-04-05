import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int W = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int time = Integer.parseInt(br.readLine());

        int nx = (x + time) % (2 * W);
        int ny = (y + time) % (2 * H);

        if (nx > W) nx = 2 * W - nx;
        if (ny > H) ny = 2 * H - ny;

        System.out.println(nx + " " + ny);
    }
}
