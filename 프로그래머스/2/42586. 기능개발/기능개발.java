import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            days[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }
        
        int current = days[0];
        int count = 1;
        
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < days.length; i++){
            if(days[i] <= current){
                count++;
            } else {
                result.add(count);
                current = days[i];
                count = 1;
            }
        }
        result.add(count);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}