import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        List<Integer> list = new ArrayList<>();
        
        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};
        
        int one = 0, two = 0, three = 0;
        
        for(int i = 0 ; i < answers.length; i++){
            
            if(answer1[i%answer1.length] == answers[i])
                one++;
            if(answer2[i%answer2.length] == answers[i])
                two++;
            if(answer3[i%answer3.length] == answers[i])
                three++;
        }
        
        int max = Math.max(Math.max(one,two), three);
        
        if ( one == max ){
            list.add(1);
        }
        if ( two == max ){
            list.add(2);
        }
        if ( three == max ){
            list.add(3);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}