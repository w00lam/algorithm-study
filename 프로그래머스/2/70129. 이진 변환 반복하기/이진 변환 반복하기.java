class Solution {
    public int[] solution(String s) {
        int changeCount = 0;
        int zeroCount = 0;
        
        while(!s.equals("1")){
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                if ( c == '0' ) {
                    zeroCount++;
                } else {
                    sb.append(c);
                }
            }
            
            int c = sb.length();
            s = Integer.toBinaryString(c);
            
            changeCount++;
        }
        
        return new int[]{changeCount, zeroCount};
    }
}