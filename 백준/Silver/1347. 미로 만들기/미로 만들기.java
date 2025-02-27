import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 방향 초기화
        char[] direction = {'S','E','N','W'};  // 'N', 'S', 'E', 'W'
        int dIdx = 0;

        int maxE = 0, maxW = 0, maxS = 0, maxN = 0;

        int x = 0;
        int y = 0;
        String move = br.readLine();

        for (int i = 0; i < move.length(); i++){
            char m = move.charAt(i);

            if (m == 'R'){
                dIdx++;
                if (dIdx == 4){
                    dIdx = 0;
                }
            }
            if (m == 'L'){
                dIdx--;
                if (dIdx == -1){
                    dIdx = 3;
                }
            }

            if (m == 'F'){

                if (direction[dIdx] == 'S'){
                    y++;
                    if ( maxS < y ){
                        maxS = y;
                    }
                }
                if (direction[dIdx] == 'E'){
                    x--;
                    if ( maxE > x ){
                        maxE = x;
                    }
                }
                if (direction[dIdx] == 'N'){
                    y--;
                    if ( maxN > y ){
                        maxN = y;
                    }
                }
                if (direction[dIdx] == 'W'){
                    x++;
                    if ( maxW < x ){
                        maxW = x;
                    }
                }
            }
        }

        int[][] map = new int[maxS - maxN +1][maxW - maxE +1];
        x = Math.abs(maxN);
        y = Math.abs(maxE);
        map[x][y] = 1;
        dIdx = 0;
        
        for (int i = 0 ; i < move.length(); i++){

            char m = move.charAt(i);

            if (m == 'R'){
                dIdx++;
                if (dIdx == 4){
                    dIdx = 0;
                }
            }
            if (m == 'L'){
                dIdx--;
                if (dIdx == -1){
                    dIdx = 3;
                }
            }

            if (m == 'F'){
                if(direction[dIdx] == 'S'){
                    x++;
                }
                if (direction[dIdx] == 'E'){
                    y--;
                }
                if (direction[dIdx] == 'N'){
                    x--;
                }
                if (direction[dIdx] == 'W'){
                    y++;
                }
                map[x][y] = 1;
            }
        }

        for (int i = 0; i < map.length; i++){
            for (int j = 0 ; j < map[i].length; j++){
                if(map[i][j] == 1){
                    System.out.print(".");
                }else{
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
