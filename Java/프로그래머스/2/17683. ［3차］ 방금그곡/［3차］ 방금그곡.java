import java.time.*;
import java.util.*;

class Solution {
    
    public String compShap(String melody) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < melody.length(); i++) {
            if (i < melody.length() - 1 && melody.charAt(i + 1) == '#') {
                sb.append(Character.toLowerCase(melody.charAt(i)));
                i++; // skip #
            } else {
                sb.append(melody.charAt(i));
            }
        }

        return sb.toString();
    }

    public String solution(String m, String[] musicinfos) {

        m = compShap(m);

        int maxTime = 0;
        String answer = "(None)";

        for (String music : musicinfos) {
            String[] info = music.split(",");
            LocalTime start = LocalTime.parse(info[0]);
            LocalTime end = LocalTime.parse(info[1]);
            int playTime = (int) Duration.between(start, end).toMinutes();

            String title = info[2];
            String melody = compShap(info[3]);

            StringBuilder fullMelody = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                fullMelody.append(melody.charAt(i % melody.length()));
            }

            if (fullMelody.toString().contains(m)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }
}