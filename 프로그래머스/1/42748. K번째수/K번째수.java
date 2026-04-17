import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            
            int[] tmp = new int[end - start + 1];
            
            for (int j = start; j <= end; j++){
                tmp[j - start] = array[j - 1];
            }
            
            Arrays.sort(tmp);
            answer[i] = tmp[k - 1];
        }
        
        return answer;
    }
}