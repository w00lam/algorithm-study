import java.util.*;

class Solution {
    static class Plan {
        String name;
        int start;
        int playtime;

        Plan(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }

    public String[] solution(String[][] plans) {
        List<Plan> planList = new ArrayList<>();

        for (String[] plan : plans) {
            String name = plan[0];
            int start = convertToMinute(plan[1]);
            int playtime = Integer.parseInt(plan[2]);

            planList.add(new Plan(name, start, playtime));
        }

        planList.sort((a, b) -> a.start - b.start);

        Stack<Plan> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < planList.size() - 1; i++) {
            Plan current = planList.get(i);
            Plan next = planList.get(i + 1);

            int timeGap = next.start - current.start;

            if (timeGap < current.playtime) {
                current.playtime -= timeGap;
                stack.push(current);
            } else {
                result.add(current.name);

                int remainTime = timeGap - current.playtime;

                while (remainTime > 0 && !stack.isEmpty()) {
                    Plan paused = stack.pop();

                    if (remainTime >= paused.playtime) {
                        result.add(paused.name);
                        remainTime -= paused.playtime;
                    } else {
                        paused.playtime -= remainTime;
                        stack.push(paused);
                        remainTime = 0;
                    }
                }
            }
        }

        Plan last = planList.get(planList.size() - 1);
        result.add(last.name);

        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }

        return result.toArray(new String[0]);
    }

    private int convertToMinute(String time) {
        String[] split = time.split(":");

        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }
}