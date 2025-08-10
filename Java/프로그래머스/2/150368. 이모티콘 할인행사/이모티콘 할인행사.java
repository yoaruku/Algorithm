import java.util.*;

class Solution {
    // 할인율 배열
    static final int[] discountRates = {10, 20, 30, 40};
    // 최대 이모티콘 플러스 가입자 수
    static int maxPlusUsers = 0;
    // 최대 이모티콘 매출액
    static int maxSales = 0;
    // 이모티콘 개수
    static int m;
    // 사용자 정보
    static int[][] gUsers;
    // 이모티콘 정가 정보
    static int[] gEmoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        // 전역 변수 초기화
        m = emoticons.length;
        gUsers = users;
        gEmoticons = emoticons;

        // 각 이모티콘에 대한 할인율을 저장할 배열
        int[] discounts = new int[m];

        // 깊이 우선 탐색으로 모든 할인율 조합을 탐색 시작
        dfs(0, discounts);

        return new int[]{maxPlusUsers, maxSales};
    }

    /**
     * 깊이 우선 탐색(DFS)을 통해 모든 할인율 조합을 생성하고 결과를 계산하는 함수
     * @param depth 현재 할인율을 결정할 이모티콘의 인덱스
     * @param discounts 현재까지 결정된 할인율 배열
     */
    public void dfs(int depth, int[] discounts) {
        // 모든 이모티콘에 대한 할인율이 결정되었을 경우
        if (depth == m) {
            calculateResult(discounts);
            return;
        }

        // 현재 이모티콘(depth)에 대해 가능한 모든 할인율(10, 20, 30, 40)을 적용
        for (int rate : discountRates) {
            discounts[depth] = rate;
            // 다음 이모티콘의 할인율을 결정하기 위해 재귀 호출
            dfs(depth + 1, discounts);
        }
    }

    /**
     * 특정 할인율 조합에 대한 결과를 계산하고, 최적의 결과인지 확인하여 업데이트하는 함수
     * @param discounts 현재 적용된 할인율 조합
     */
    public void calculateResult(int[] discounts) {
        int currentPlusUsers = 0;
        int currentSales = 0;

        // 각 사용자에 대해 순회
        for (int[] user : gUsers) {
            int userMinDiscountRate = user[0];
            int userPriceThreshold = user[1];
            int userPurchaseCost = 0;

            // 각 이모티콘에 대해 순회
            for (int i = 0; i < m; i++) {
                // 사용자의 기준 할인율보다 이모티콘의 할인율이 높거나 같으면 구매
                if (discounts[i] >= userMinDiscountRate) {
                    userPurchaseCost += gEmoticons[i] * (100 - discounts[i]) / 100;
                }
            }

            // 이모티콘 구매 비용이 기준 가격 이상이면 플러스 서비스 가입
            if (userPurchaseCost >= userPriceThreshold) {
                currentPlusUsers++;
            } else { // 아니면 이모티콘 구매
                currentSales += userPurchaseCost;
            }
        }

        // 최적 결과 업데이트 로직
        // 1. 플러스 가입자 수가 더 많으면 무조건 업데이트
        if (currentPlusUsers > maxPlusUsers) {
            maxPlusUsers = currentPlusUsers;
            maxSales = currentSales;
        } 
        // 2. 플러스 가입자 수가 같다면, 판매액이 더 클 때만 업데이트
        else if (currentPlusUsers == maxPlusUsers) {
            if (currentSales > maxSales) {
                maxSales = currentSales;
            }
        }
    }
}