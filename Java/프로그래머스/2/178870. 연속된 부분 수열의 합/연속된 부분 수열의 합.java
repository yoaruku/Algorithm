class Solution {
    public static int[] solution(int[] sequence, int k) {

        int start = 0, end = sequence.length, count = Integer.MAX_VALUE;
        int right = 0, left = 0;
        int sum = sequence[0];

        while (right < sequence.length){
            if (sum == k){
                int diff = right - left;

                if (diff < count){
                    count = diff;
                    start = left;
                    end = right;
                }
            }

            if (sum <= k){
                right++;
                if (right < sequence.length){
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left++];
            }
        }
        
        return new int[]{start, end};
    }
}