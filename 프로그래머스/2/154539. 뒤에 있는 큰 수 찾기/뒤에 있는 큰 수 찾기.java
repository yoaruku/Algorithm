class Solution {
    public int[] solution(int[] numbers) {
        // 결과값이 길이는 입력값과 동일
        int[] result = new int[numbers.length];

        // lastOfIndex -1로 고정
        result[numbers.length-1] = -1;

        for (int i = numbers.length - 2; i >= 0; i--) {

            int max = -1;

            if(numbers[i] < numbers[i+1]) {
                max = numbers[i+1];
            } else {
                for (int j = i + 1; j < numbers.length; j++) {
                    if(result[j] > numbers[i]) {
                        max = result[j];
                        break;
                    }

                    if(result[j] == -1) {
                        break;
                    }
                }
            }

            result[i] = max;
        }

        return result;
    }
}