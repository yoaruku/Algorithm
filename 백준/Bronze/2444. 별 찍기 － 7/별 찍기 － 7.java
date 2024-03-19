import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int curv = num;
        
        for(int i = 0; i < 2 * num - 1 ; i++){
            for(int j = 0; j < 2 * num - 1 ; j++){
                if(j >= ((2 * num - 1) - curv) && j < curv){
                    System.out.print("*");

                }
                if(j < ((2 * num - 1) - curv)){
                    System.out.print(" ");
                }

//                else {
//                    System.out.print(" ");
//                }
            }

            if(i < num - 1){
                curv++;
            }
            else{
                curv--;
            }
            System.out.println();
        }
    }

}