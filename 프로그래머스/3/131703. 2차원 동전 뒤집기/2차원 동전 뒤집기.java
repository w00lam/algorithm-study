class Solution {

    public int solution(int[][] beginning, int[][] target) {
        int rows = beginning.length;
        int cols = beginning[0].length;
        int answer = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << rows); mask++) {
            int flipCount = Integer.bitCount(mask);
            boolean possible = true;

            for (int col = 0; col < cols; col++) {
                int firstRowFlip = (mask >> 0) & 1;
                int current = beginning[0][col] ^ firstRowFlip;

                int colFlip = current == target[0][col] ? 0 : 1;

                if (colFlip == 1) {
                    flipCount++;
                }

                for (int row = 1; row < rows; row++) {
                    int rowFlip = (mask >> row) & 1;

                    current = beginning[row][col]
                            ^ rowFlip
                            ^ colFlip;

                    if (current != target[row][col]) {
                        possible = false;
                        break;
                    }
                }

                if (!possible) {
                    break;
                }
            }

            if (possible) {
                answer = Math.min(answer, flipCount);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}