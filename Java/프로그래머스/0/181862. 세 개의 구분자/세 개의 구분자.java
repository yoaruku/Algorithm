import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] split = myStr.split("a|b|c");
        List<String> list = new ArrayList<>();

        for (String str : split){
            if (!str.isEmpty()){
                list.add(str);
            }
        }
        
        if (list.isEmpty()){
            list.add("EMPTY");
        }

        return list.toArray(new String[list.size()]);
    }
}