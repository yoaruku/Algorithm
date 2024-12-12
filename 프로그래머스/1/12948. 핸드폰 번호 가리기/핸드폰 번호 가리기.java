class Solution {
    public String solution(String phone_number) {
        char[] split = phone_number.toCharArray();

        for (int i = 0; i < split.length - 4; i++) {
            split[i] = '*';
        }

        return String.valueOf(split);
    }
}