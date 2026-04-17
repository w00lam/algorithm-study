import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            answer[i] = map.containsKey(c) ? i - map.get(c) : -1;
            
            map.put(c, i);
        }
        return answer;
    }
}