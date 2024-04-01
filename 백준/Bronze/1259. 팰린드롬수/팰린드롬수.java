import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = -1;
        while (true) {
            num = sc.nextInt();

            if(num ==0) return;

            String result = "yes";

            String intToStr = "" + num;

            for (int i = 0; i < intToStr.length(); i++) {
                if (intToStr.charAt(i) != intToStr.charAt(intToStr.length() - 1 - i)) {
                    result = "no";
                }
            }

            System.out.println(result);

        }
    }
}