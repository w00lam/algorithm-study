import java.util.*;

class Solution {

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = checkRoom(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean checkRoom(String[] room) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (room[row].charAt(col) == 'P') {
                    if (!bfs(room, row, col)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean bfs(String[] room, int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

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
                int nextDist = dist + 1;

                if (nextRow < 0 || nextRow >= 5 || nextCol < 0 || nextCol >= 5) {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                if (nextDist > 2) {
                    continue;
                }

                if (room[nextRow].charAt(nextCol) == 'X') {
                    continue;
                }

                if (room[nextRow].charAt(nextCol) == 'P') {
                    return false;
                }

                visited[nextRow][nextCol] = true;
                queue.offer(new int[]{nextRow, nextCol, nextDist});
            }
        }

        return true;
    }
}