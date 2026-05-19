import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> leftSet = new HashSet<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        
        for (int top : topping) {
            rightMap.put(top, rightMap.getOrDefault(top, 0) + 1);
        }
        
        for (int top : topping) {
            leftSet.add(top);
            
            rightMap.put(top, rightMap.get(top) - 1);
            if (rightMap.get(top) == 0) {
                rightMap.remove(top);
            }
            
            if(rightMap.size() == leftSet.size()){
                answer++;
            }
        }

        return answer;
    }
}