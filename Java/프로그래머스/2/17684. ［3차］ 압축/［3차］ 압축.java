import java.util.*;

class Solution {
    public static int[] solution(String msg) {

        Set<String> set = new HashSet<>();
        List<String> dic = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        dic.add(" ");

        for (int i = 0 ; i < 26; i++){
            String str = Character.toString('A'+i);
            dic.add(str);
            set.add(str);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : msg.toCharArray()){
            sb.append(c);
            if (!set.contains(sb.toString())){
                result.add(dic.indexOf(sb.substring(0, sb.length()-1)));
                set.add(sb.toString());
                dic.add(sb.toString());
                sb.setLength(0);
                sb.append(c);
            }
        }

        if (sb.length() != 0){
            result.add(dic.indexOf(sb.toString()));
        }


        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}