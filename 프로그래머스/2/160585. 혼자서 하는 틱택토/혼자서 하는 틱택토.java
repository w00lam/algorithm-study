class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char ch = board[row].charAt(col);

                if (ch == 'O') {
                    oCount++;
                } else if (ch == 'X') {
                    xCount++;
                }
            }
        }

        boolean oWin = check(board, 'O');
        boolean xWin = check(board, 'X');

        if (xCount > oCount || oCount > xCount + 1) {
            return 0;
        }

        if (oWin && xWin) {
            return 0;
        }

        if (oWin && oCount != xCount + 1) {
            return 0;
        }

        if (xWin && oCount != xCount) {
            return 0;
        }

        return 1;
    }

    private boolean check(String[] board, char target) {
        for (int row = 0; row < 3; row++) {
            if (board[row].charAt(0) == target &&
                board[row].charAt(1) == target &&
                board[row].charAt(2) == target) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0].charAt(col) == target &&
                board[1].charAt(col) == target &&
                board[2].charAt(col) == target) {
                return true;
            }
        }

        if (board[0].charAt(0) == target &&
            board[1].charAt(1) == target &&
            board[2].charAt(2) == target) {
            return true;
        }

        if (board[0].charAt(2) == target &&
            board[1].charAt(1) == target &&
            board[2].charAt(0) == target) {
            return true;
        }

        return false;
    }
}