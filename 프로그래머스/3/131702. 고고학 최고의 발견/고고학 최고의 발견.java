class Solution {

    private int n;
    private int answer = Integer.MAX_VALUE;
    private int[][] original;
    private int[] firstRow;

    private final int[] dr = {0, -1, 1, 0, 0};
    private final int[] dc = {0, 0, 0, -1, 1};

    public int solution(int[][] clockHands) {
        n = clockHands.length;
        original = clockHands;
        firstRow = new int[n];

        makeFirstRow(0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void makeFirstRow(int depth) {
        if (depth == n) {
            simulate();
            return;
        }

        for (int count = 0; count < 4; count++) {
            firstRow[depth] = count;
            makeFirstRow(depth + 1);
        }
    }

    private void simulate() {
        int[][] board = copyBoard();
        int totalCount = 0;

        for (int col = 0; col < n; col++) {
            int count = firstRow[col];

            rotate(board, 0, col, count);
            totalCount += count;
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int count = (4 - board[row - 1][col]) % 4;

                rotate(board, row, col, count);
                totalCount += count;
            }
        }

        for (int col = 0; col < n; col++) {
            if (board[n - 1][col] != 0) {
                return;
            }
        }

        answer = Math.min(answer, totalCount);
    }

    private void rotate(int[][] board, int row, int col, int count) {
        if (count == 0) {
            return;
        }

        for (int direction = 0; direction < 5; direction++) {
            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];

            if (nextRow < 0 || nextRow >= n
                    || nextCol < 0 || nextCol >= n) {
                continue;
            }

            board[nextRow][nextCol]
                    = (board[nextRow][nextCol] + count) % 4;
        }
    }

    private int[][] copyBoard() {
        int[][] copy = new int[n][n];

        for (int row = 0; row < n; row++) {
            copy[row] = original[row].clone();
        }

        return copy;
    }
}