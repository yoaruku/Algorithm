import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(String[] seoul) {
        List<String> result = Arrays.stream(seoul).collect(Collectors.toList());

        return "김서방은 "+result.indexOf("Kim")+"에 있다";
    }
}