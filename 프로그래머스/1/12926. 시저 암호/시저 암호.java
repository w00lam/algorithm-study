class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()){
            sb.append(c == ' '
                      ? ' '
                      : Character.isUpperCase(c)
                      ? (char)((c - 'A' + n) % 26 + 'A')
                      : (char)((c - 'a' + n) % 26 + 'a')
                     );
        }
        
        return sb.toString();
    }
}