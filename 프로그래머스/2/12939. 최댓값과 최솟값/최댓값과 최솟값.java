import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
        
            if(n < min){
                min = n;
            }   
            if(n > max){
                max = n;
            }   
        }
        
        return min + " " + max;
    }
}