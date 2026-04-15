class Solution {
    public boolean solution(String s) {
        return s.matches("\\d+") && (s.length() == 4 || s.length() == 6);
    }
}