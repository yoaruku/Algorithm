class Solution {
    public long solution(long n) {
        long result = 1;

        while (result *result < n) {
            result++;
        }

        if (result *result == n) {
            result++;
            return result *result;
        }
        else{
            return -1;
        }
    }
}