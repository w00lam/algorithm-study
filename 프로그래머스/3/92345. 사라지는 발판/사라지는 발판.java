class Solution {

    private int rows;
    private int cols;

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        rows = board.length;
        cols = board[0].length;

        return dfs(
                board,
                aloc[0], aloc[1],
                bloc[0], bloc[1]
        );
    }

    private int dfs(
            int[][] board,
            int curRow,
            int curCol,
            int opponentRow,
            int opponentCol
    ) {
        if (board[curRow][curCol] == 0) {
            return 0;
        }

        int winCount = Integer.MAX_VALUE;
        int loseCount = 0;

        for (int direction = 0; direction < 4; direction++) {
            int nextRow = curRow + dr[direction];
            int nextCol = curCol + dc[direction];

            if (!isMovable(board, nextRow, nextCol)) {
                continue;
            }

            board[curRow][curCol] = 0;

            int moveCount = dfs(
                    board,
                    opponentRow,
                    opponentCol,
                    nextRow,
                    nextCol
            ) + 1;

            board[curRow][curCol] = 1;

            if (moveCount % 2 == 1) {
                winCount = Math.min(winCount, moveCount);
            } else {
                loseCount = Math.max(loseCount, moveCount);
            }
        }

        return winCount == Integer.MAX_VALUE
                ? loseCount
                : winCount;
    }

    private boolean isMovable(int[][] board, int row, int col) {
        return row >= 0
                && row < rows
                && col >= 0
                && col < cols
                && board[row][col] == 1;
    }
}