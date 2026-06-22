class Solution {
    private int n;
    private int answer;
    private int[] queens;

    public int solution(int n) {
        this.n = n;
        this.answer = 0;
        this.queens = new int[n];

        dfs(0);

        return answer;
    }

    private void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlace(row, col)) {
                queens[row] = col;
                dfs(row + 1);
            }
        }
    }

    private boolean canPlace(int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];

            if (prevCol == col) {
                return false;
            }

            if (Math.abs(row - prevRow) == Math.abs(col - prevCol)) {
                return false;
            }
        }

        return true;
    }
}