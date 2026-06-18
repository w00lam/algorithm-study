import java.util.*;

class Solution {
    private String[] board;
    private int rows;
    private int cols;

    private int startRow;
    private int startCol;
    private int goalRow;
    private int goalCol;

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int solution(String[] board) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length();

        findPositions();

        return bfs();
    }

    private void findPositions() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cell = board[row].charAt(col);

                if (cell == 'R') {
                    startRow = row;
                    startCol = col;
                }

                if (cell == 'G') {
                    goalRow = row;
                    goalCol = col;
                }
            }
        }
    }

    private int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int count = current[2];

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = row;
                int nextCol = col;

                while (true) {
                    int nr = nextRow + dr[dir];
                    int nc = nextCol + dc[dir];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                        break;
                    }

                    if (board[nr].charAt(nc) == 'D') {
                        break;
                    }

                    nextRow = nr;
                    nextCol = nc;
                }

                if (nextRow == goalRow && nextCol == goalCol) {
                    return count + 1;
                }

                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol, count + 1});
                }
            }
        }

        return -1;
    }
}