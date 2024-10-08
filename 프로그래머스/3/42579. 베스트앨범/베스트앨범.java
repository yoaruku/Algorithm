import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        List<Integer> result = new ArrayList<>();

        Map<String, Integer> genresPlays = new HashMap<>();

        Map<String, HashMap<Integer, Integer>> songs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            // 각 장르별 재생 횟수 저장
            genresPlays.put(genres[i], genresPlays.getOrDefault(genres[i], 0) + plays[i]);

            // 각 장르별 노래번호, 재생 횟수 저장
            if (!songs.containsKey(genres[i])) {
                songs.put(genres[i], new HashMap<>());
            }

            songs.get(genres[i]).put(i, plays[i]);
        }

        System.out.println("songs = " + songs);
        System.out.println("genresPlays = " + genresPlays);

        // 장르별 재생 횟수를 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(genresPlays.entrySet());

        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // 장르별 재생 횟수 내림차수 순 반복
        for (Map.Entry<String, Integer> entry : list) {

            HashMap<Integer, Integer> map = songs.get(entry.getKey());
            List<Integer> playList = new ArrayList<>(map.keySet());

            Collections.sort(playList, (s1, s2) -> map.get(s2) - map.get(s1));

            if (!playList.isEmpty()) {
                result.add(playList.get(0));
                playList.remove(0);
            }
            if (!playList.isEmpty())
                result.add(playList.get(0));

        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}