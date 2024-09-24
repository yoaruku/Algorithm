import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        // 1. 정렬
        Arrays.sort(phone_book);

        // 2. 접두사 검사
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false; // 접두사 관계가 발견됨
            }
        }

        return true; // 모든 검사 통과
    
    }
}