class Solution {
    public int solution(int[] numbers) {
        int total = 45;

        for (int i : numbers){
            total -= i;
        }

        return total;
    }
}