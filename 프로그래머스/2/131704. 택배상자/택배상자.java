import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int nextBox = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int target : order) {
            while(nextBox < target){
                stack.push(nextBox);
                nextBox++;
            }
            
            if(nextBox == target){
                answer++;
                nextBox++;
            } else if(!stack.isEmpty() && stack.peek() == target){
                answer++;
                stack.pop();
            } else{
                break;
            }
        }
        
        return answer;
    }
}