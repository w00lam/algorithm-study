import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> minPressMap = new HashMap<>();
        
        for(String keys : keymap){
            for(int i = 0; i < keys.length(); i++){
                char ch = keys.charAt(i);
                int pressCount = i + 1;
                
                minPressMap.put(ch, Math.min(minPressMap.getOrDefault(ch, Integer.MAX_VALUE), pressCount));
            }
        }
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++){
            int total = 0;
            boolean possible = true;
            
            for(int j = 0; j < targets[i].length(); j++){
                char ch = targets[i].charAt(j);
                
                if(!minPressMap.containsKey(ch)) {
                    possible = false;
                    break;
                }
                
                total += minPressMap.get(ch);
            }
            
            answer[i] = possible ? total : -1;
        }
        
        return answer;
    }
}