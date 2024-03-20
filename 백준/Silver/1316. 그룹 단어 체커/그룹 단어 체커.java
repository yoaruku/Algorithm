import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();

        int groupCheck = 0;

        loop1:
        for (int i = 0; i < loop; i++) {

            String str = sc.next();
            char tmp = str.charAt(0);
            int[] alpha = new int[26];

            int j = 0;
            while(true){
                if (alpha[str.charAt(j) - 'a'] == 0) {

                    if (str.charAt(j) != tmp) {
                        alpha[tmp - 'a'] += 1;
                        tmp = str.charAt(j);
                    }
                } else {
                   break;
                }

                j++;
                if (j >= str.length()) {
                    groupCheck++;
                    break;
                }

            }
        }
        System.out.println(groupCheck);

    }

}