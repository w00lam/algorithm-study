import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0;i < tangerine.length; i++){
            int size = tangerine[i];
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        Collections.sort(counts, Collections.reverseOrder());
        
        int answer = 0;
        int count = 0;
        
        for(int i = 0; i < counts.size(); i++){
            count += counts.get(i);
            answer++;
            
            if( count >= k){
                break;
            }
        }
        
        return answer;
    }
}