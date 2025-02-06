import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Solution {
public static String[] solution(String[][] plans) {
        PriorityQueue<Plan> planQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        Stack<Plan> workStack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (String[] plan : plans) {
            planQueue.offer(new Plan(plan[0], plan[1], plan[2]));
        }

        int now = planQueue.peek().time; // 첫 작업 시작 시간

        while (!planQueue.isEmpty()) {
            Plan plan = planQueue.poll(); // 현재 작업
            now = plan.time; // 현재 시간 갱신

            // 마지막 작업인 경우
            if (planQueue.isEmpty()) {
                result.add(plan.name);
                now += plan.workTime;
                break;
            }

            // 다음 작업 시작 시간
            int nextStartTime = planQueue.peek().time;

            // 현재 작업을 끝낼 수 있는 경우
            if (now + plan.workTime <= nextStartTime) {
                result.add(plan.name);
                now += plan.workTime;

                // 작업 스택에서 꺼내서 가능한 것부터 수행
                while (!workStack.isEmpty()) {
                    Plan workPlan = workStack.peek();

                    if (now + workPlan.workTime <= nextStartTime) {
                        result.add(workStack.pop().name);
                        now += workPlan.workTime;
                    } else {
                        // 일부만 수행하고 다시 넣어야 하는 경우
                        workPlan.workTime -= nextStartTime - now;
                        now = nextStartTime;
                        break;
                    }
                }
            } else {
                // 현재 작업을 끝낼 수 없는 경우
                plan.workTime -= nextStartTime - now;
                workStack.push(plan);
                now = nextStartTime;
            }
        }

        // 스택에 남은 작업 수행
        while (!workStack.isEmpty()) {
            result.add(workStack.pop().name);
        }

        return result.toArray(new String[0]);
    }

    static class Plan {
        String name;
        int time;
        int workTime;

        public Plan(String name, String time, String workTime) {
            this.name = name;
            String[] strTime = time.split(":");
            this.time = Integer.parseInt(strTime[0]) * 60 + Integer.parseInt(strTime[1]);
            this.workTime = Integer.parseInt(workTime);
        }
    }
}