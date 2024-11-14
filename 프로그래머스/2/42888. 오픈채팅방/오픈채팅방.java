import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        // 닉네임 저장
        Map<String, String> name = new HashMap<>();

        for (String str : record){
            String[] split = str.split(" ");

            // 변경일 때만 닉네임 저장
            if (split.length == 3){
                name.put(split[1], split[2]);
            }
        }

        // 결과 String 저장
        List<String> result = new ArrayList<>();

        for (String str : record){
            
            String[] split = str.split(" ");
            
            // Enter, Leave만 String 생성
            switch (split[0]){
                case "Enter" : result.add(name.get(split[1]) + "님이 들어왔습니다."); break;
                case "Leave": result.add(name.get(split[1]) + "님이 나갔습니다."); break;
                default: break;
            }
        }

        // 결과 List -> String[] 형식으로 변경
        return result.toArray(new String[result.size()]);
    }
}