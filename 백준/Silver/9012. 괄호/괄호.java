import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        String[] result = new String[num];

        for (int i = 0; i < result.length; i++) {

            int count = 0;
            result[i] = sc.next();

            for (int j = 0; j < result[i].length(); j++) {
                char scope = '\0';

                scope = result[i].charAt(j);

                if (scope == '(') {
                    count++;
                } else {
                    count--;
                }

                if (count < 0) {
                    break;
                }
            }

            if (count != 0) {
                result[i] = "NO";
            } else {
                result[i] = "YES";
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}