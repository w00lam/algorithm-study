import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(person1[i % person1.length] == answers[i]){
                cnt1++;
            }
            if(person2[i % person2.length] == answers[i]){
                cnt2++;
            }
            if(person3[i % person3.length] == answers[i]){
                cnt3++;
            }
        }
        
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        List<Integer> list = new ArrayList<>();
        
        if(cnt1 == max) list.add(1);
        if(cnt2 == max) list.add(2);
        if(cnt3 == max) list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}