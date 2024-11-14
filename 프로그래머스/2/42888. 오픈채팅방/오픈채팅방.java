import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> name = new HashMap<>();

        for (String str : record){
            String[] split = str.split(" ");

            if (split.length == 3){
                name.put(split[1], split[2]);
            }
        }

        List<String> result = new ArrayList<>();

        for (String str : record){
            String[] split = str.split(" ");
            switch (split[0]){
                case "Enter" : result.add(name.get(split[1]) + "님이 들어왔습니다."); break;
                case "Leave": result.add(name.get(split[1]) + "님이 나갔습니다."); break;
                default: break;
            }
        }

        return result.toArray(new String[result.size()]);
    }
}