class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        for(char c : X.toCharArray()){
            countX[c - '0']++;
        }
        for(char c : Y.toCharArray()){
            countY[c - '0']++;
        }
        
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(countX[i], countY[i]);
            
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        
        if (sb.length() == 0) return "-1";
        if (sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}