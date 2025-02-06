import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String number = "";
        boolean flag = false;

        int result = 0;

        for (char c : input.toCharArray()) {

            if (Character.isDigit(c)) {
                number += c;
            }


            if (c == '+' || c == '-') {

                result = sum(result, flag, number);

                if (c == '-') {
                    flag = true;
                }
                number = "";
            }
        }

        result = sum(result, flag, number);

        System.out.println(result);
    }

    public static int sum(int result, boolean flag, String number){

        if (flag) {
            result -= Integer.parseInt(number);
        } else {
            result += Integer.parseInt(number);
        }

        return result;
    }
}