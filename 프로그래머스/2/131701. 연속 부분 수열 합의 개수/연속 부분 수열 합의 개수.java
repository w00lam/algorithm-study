import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[elements.length * 2];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = elements[i % elements.length];
        }
        
        for(int len = 1; len <= elements.length; len++){
            for(int start = 0; start < elements.length; start++){
                int sum = 0;
                
                for(int i = 0; i < len; i++){
                    sum += arr[start + i];
                }
                
                set.add(sum);
            }
        }
        
        return set.size();
    }
}