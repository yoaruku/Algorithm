import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        char[] cArr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            cArr[i] = str.charAt(i);
        }

        int count = 0;
        for (int i = 0; i < cArr.length; i++) {
            if(cArr[i] == cArr[cArr.length - 1 - i]){
                count++;
            }
        }

        System.out.println((count == cArr.length)?1:0);
    }

}