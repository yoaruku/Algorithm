import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int subjectNum = sc.nextInt();

        int[] pointArr = new int[subjectNum];

        for(int i = 0; i < subjectNum; i++){
            pointArr[i] = sc.nextInt();
        }

        double maxPoint = 0;
        for (int i = 0; i < pointArr.length; i++){
            maxPoint = Math.max(maxPoint, pointArr[i]);
        }

        double avgPoint = 0;
        for(int i = 0; i < pointArr.length; i++){
            double changePoint = 0;

            changePoint = pointArr[i] / maxPoint * 100;
//            if(pointArr[i] != maxPoint) changePoint = pointArr[i] / maxPoint * 100;
//            else changePoint = pointArr[i];
            avgPoint += changePoint;
//            System.out.println("changePoint = " + changePoint);
        }
        avgPoint /= pointArr.length;

//        System.out.println("avgPoint = " + avgPoint);
        System.out.println(avgPoint);

    }
}
