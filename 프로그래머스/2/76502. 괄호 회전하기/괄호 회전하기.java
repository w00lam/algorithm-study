import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
           if (isValid(s)) {
                answer++;
            }
            
            s = s.substring(1) + s.substring(0, 1);
        }
        
        return answer;
    }
    
    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                } else{
                    if(stack.peek() == '(' && c != ')'){
                        return false;
                    }
                    if(stack.peek() == '{' && c != '}'){
                        return false;
                    }
                    if(stack.peek() == '[' && c != ']'){
                        return false;
                    }
                    
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty();
    }
}