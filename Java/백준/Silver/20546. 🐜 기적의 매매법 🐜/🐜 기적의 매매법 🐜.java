import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bank = new int[2][2];  // [][0] = 현금, [][1] = 주식

        int seed = Integer.parseInt(br.readLine());
        bank[0][0] = seed;  // BNP 초기 현금
        bank[1][0] = seed;  // TIMING 초기 현금

        String[] input = br.readLine().split(" ");
        int[] prices = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }

        int upCount = 0, downCount = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            // BNP 매수
            int buyBNP = bank[0][0] / price;
            bank[0][1] += buyBNP;
            bank[0][0] -= buyBNP * price;

            // TIMING 전략은 3일 연속 상승/하락한 경우만 반응
            if (i > 0) {
                if (prices[i] > prices[i - 1]) {
                    upCount++;
                    downCount = 0;
                } else if (prices[i] < prices[i - 1]) {
                    downCount++;
                    upCount = 0;
                } else {
                    upCount = 0;
                    downCount = 0;
                }

                if (downCount >= 3) {
                    int buy = bank[1][0] / price;
                    bank[1][1] += buy;
                    bank[1][0] -= buy * price;
                }

                if (upCount >= 3) {
                    bank[1][0] += bank[1][1] * price;
                    bank[1][1] = 0;
                }
            }
        }

        int finalPrice = prices[prices.length - 1];
        int totalBNP = bank[0][0] + bank[0][1] * finalPrice;
        int totalTIMING = bank[1][0] + bank[1][1] * finalPrice;

        if (totalBNP > totalTIMING) {
            System.out.println("BNP");
        } else if (totalBNP < totalTIMING) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
