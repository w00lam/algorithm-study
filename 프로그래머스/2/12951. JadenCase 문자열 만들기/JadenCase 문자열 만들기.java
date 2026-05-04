class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' '){
                sb.append(c);
                isStart = true;
            }else if(isStart){
                sb.append(Character.toUpperCase(c));
                isStart = false;
            }else {
                sb.append(Character.toLowerCase(c));
            }
        }
        
        return sb.toString();
    }
}