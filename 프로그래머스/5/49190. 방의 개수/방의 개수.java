import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        Set<String> visitedPoints = new HashSet<>();
        Set<String> visitedEdges = new HashSet<>();

        int x = 0, y = 0;
        visitedPoints.add(x + "," + y); // 시작점 저장

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        int result = 0;

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) { // 교차점 처리를 위해 2번 반복
                int newX = x + dx[arrow];
                int newY = y + dy[arrow];

                String currentPoint = x + "," + y;
                String newPoint = newX + "," + newY;
                String edge1 = currentPoint + "->" + newPoint;
                String edge2 = newPoint + "->" + currentPoint;

                // 새로운 점인 경우
                if (!visitedPoints.contains(newPoint)) {
                    visitedPoints.add(newPoint);
                } else if (!visitedEdges.contains(edge1)) {
                    // 이미 방문한 점이지만 새로운 선분인 경우
                    result++;
                }

                // 새로운 선분인 경우 추가
                if (!visitedEdges.contains(edge1)) {
                    visitedEdges.add(edge1);
                    visitedEdges.add(edge2);
                }

                // 좌표 업데이트
                x = newX;
                y = newY;
            }
        }

        return result;
    }
}