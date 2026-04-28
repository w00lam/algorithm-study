import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> score = new HashMap<>();
        
        for(int i = 0; i < survey.length; i++){
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            
            int choice = choices[i];
            int point = Math.abs(choice - 4);
            
            if(choice < 4){
                score.put(disagree, score.getOrDefault(disagree, 0) + point);
            } else if(choice > 4){
                score.put(agree, score.getOrDefault(agree, 0) + point);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        answer.append(score.getOrDefault('R', 0) >= score.getOrDefault('T', 0) ? 'R' : 'T');
        answer.append(score.getOrDefault('C', 0) >= score.getOrDefault('F', 0) ? 'C' : 'F');
        answer.append(score.getOrDefault('J', 0) >= score.getOrDefault('M', 0) ? 'J' : 'M');
        answer.append(score.getOrDefault('A', 0) >= score.getOrDefault('N', 0) ? 'A' : 'N');
        
        return answer.toString();
    }
}