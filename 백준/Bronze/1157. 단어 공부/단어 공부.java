import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        char[] alpha = new char[26];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                alpha[str.charAt(i) - 'A'] += 1;
            } else {
                alpha[str.charAt(i) - 'a'] += 1;
            }
        }

        char ch = '?';
        int max = 0;

        for (int i = 0; i < alpha.length; i++) {
            if (max == alpha[i]) {
                ch = '?';
            } else if (max < alpha[i]) {
                ch = (char) ('A' + i);
            } else {
                continue;
            }
            max = alpha[i];
        }

        System.out.println(ch);

    }

}