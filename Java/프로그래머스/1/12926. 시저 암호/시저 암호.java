class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c)){
                sb.append(
                        (char) (65 + ((c+n) % 65) % 26)
                );
            }

            if (Character.isLowerCase(c)){
                sb.append(
                        (char) (97 + ((c+n) % 97) % 26)
                );
            }

            if (c == ' '){
                sb.append(c);
            }
        }

        return String.valueOf(sb);
    }
}