import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());

        BigInteger result = n.add(n).subtract(BigInteger.valueOf(2));

        if (n.equals(BigInteger.ONE))
            result = BigInteger.ONE;

        System.out.println(result);
    }
}
