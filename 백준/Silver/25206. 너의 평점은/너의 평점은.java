import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float pointtotal = 0;
        float point = 0;
        float pointSum = 0;
        float grade = 0;

        String className;

        while(sc.hasNext()){

            className = sc.next();
            point = sc.nextFloat();
            className = sc.next();

            switch (className) {
                case "A+":
                    grade = 4.5f;
                    break;
                case "A0":
                    grade = 4.0f;
                    break;
                case "B+":
                    grade = 3.5f;
                    break;
                case "B0":
                    grade = 3.0f;
                    break;
                case "C+":
                    grade = 2.5f;
                    break;
                case "C0":
                    grade = 2.0f;
                    break;
                case "D+":
                    grade = 1.5f;
                    break;
                case "D0":
                    grade = 1.0f;
                    break;
                case "F":
                    grade = 0.0f;
                    break;
            }
            
            if (!className.equals("P")){

                pointtotal += point;
                pointSum += point * grade;
            }

        }

        System.out.println((pointSum / pointtotal));

    }

}