class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        int pos = 0;
        
        
        for(long idx = left; idx <= right; idx++){
            long row = idx / n;
            long col = idx % n;
            
            answer[pos] = (int)(Math.max(row, col) + 1);
            pos++;
        }
        
        return answer;
    }
}