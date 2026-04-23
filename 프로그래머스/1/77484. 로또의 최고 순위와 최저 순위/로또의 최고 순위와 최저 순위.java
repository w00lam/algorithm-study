class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int rightCount = 0;
        int zeroCount = 0;
        
        for (int number : lottos) {
            if (number == 0) {
                zeroCount++;
                continue;
            }

            for (int win : win_nums) {
                if (number == win) {
                    rightCount++;
                    break;
                }
            }
        }
        
        int max = rank(rightCount + zeroCount);
        int min = rank(rightCount);
        
        int[] answer = {max, min};
        
        return answer;
    }
    
    private int rank(int count) {
        return count < 2 ? 6 : 7 - count;
    }
}