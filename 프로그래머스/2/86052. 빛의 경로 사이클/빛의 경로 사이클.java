import java.util.*;

class Solution {
    private String[] grid;
    private boolean[][][] visited;
    private int rows;
    private int cols;

    private final int[] dr = {-1, 0, 1, 0};
    private final int[] dc = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length();
        this.visited = new boolean[rows][cols][4];

        List<Integer> answer = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int dir = 0; dir < 4; dir++) {
                    if (!visited[row][col][dir]) {
                        answer.add(trace(row, col, dir));
                    }
                }
            }
        }

        Collections.sort(answer);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int trace(int row, int col, int dir) {
        int count = 0;

        while (!visited[row][col][dir]) {
            visited[row][col][dir] = true;
            count++;

            char command = grid[row].charAt(col);

            if (command == 'R') {
                dir = (dir + 1) % 4;
            } else if (command == 'L') {
                dir = (dir + 3) % 4;
            }

            row = (row + dr[dir] + rows) % rows;
            col = (col + dc[dir] + cols) % cols;
        }

        return count;
    }
}