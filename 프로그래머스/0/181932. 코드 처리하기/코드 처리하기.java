class Solution {
    public String solution(String code) {
        String result = "";

        int mode = 0;

        for (int i = 0; i < code.length(); i++) {

            if (code.charAt(i) == '1') {
                mode = mode == 0 ? 1 : 0;
                continue;
            }

            if (mode == 1 && i % 2 == 1) {
                result += code.charAt(i);
            }

            if (mode == 0 && i % 2 == 0) {
                result += code.charAt(i);
            }
        }

        return result.isEmpty() ? "EMPTY" : result;
    }
}