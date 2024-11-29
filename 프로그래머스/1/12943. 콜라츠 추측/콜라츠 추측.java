class Solution {
    public int solution(int num) {
        return collatz(num,0);
    }

    public int collatz(long n, int cnt) {

        if (n == 1 && cnt == 0) return 0;   // n이 1일경우
        if (cnt >= 500) return -1;          // 횟수제한
        if (n == 1) return cnt;             // 목표달성

        if (n % 2 == 0) return collatz( n / 2, cnt + 1);
        else return collatz((n * 3) + 1, cnt + 1);
    }
}