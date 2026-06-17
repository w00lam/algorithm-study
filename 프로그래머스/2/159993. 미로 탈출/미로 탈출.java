import java.util.*;

class Solution {
    private String[] maps;
    private int rows;
    private int cols;

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int solution(String[] maps) {
        this.maps = maps;
        this.rows = maps.length;
        this.cols = maps[0].length();

        int[][] points = new int[3][2];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char current = maps[row].charAt(col);

                if (current == 'S') {
                    points[0][0] = row;
                    points[0][1] = col;
                } else if (current == 'L') {
                    points[1][0] = row;
                    points[1][1] = col;
                } else if (current == 'E') {
                    points[2][0] = row;
                    points[2][1] = col;
                }
            }
        }

        int toLever = bfs(
                points[0][0], points[0][1],
                points[1][0], points[1][1]
        );

        int toExit = bfs(
                points[1][0], points[1][1],
                points[2][0], points[2][1]
        );

        if (toLever == -1 || toExit == -1) {
            return -1;
        }

        return toLever + toExit;
    }

    private int bfs(int startRow, int startCol, int targetRow, int targetCol) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int dist = current[2];

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                    continue;
                }

                if (maps[nextRow].charAt(nextCol) == 'X') {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                if (nextRow == targetRow && nextCol == targetCol) {
                    return dist + 1;
                }

                visited[nextRow][nextCol] = true;
                queue.offer(new int[]{nextRow, nextCol, dist + 1});
            }
        }

        return -1;
    }
}