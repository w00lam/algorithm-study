import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> points = new ArrayList<>();

        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];

                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                long denominator = A * D - B * C;

                if (denominator == 0) {
                    continue;
                }

                long xNumerator = B * F - E * D;
                long yNumerator = E * C - A * F;

                if (xNumerator % denominator != 0 || yNumerator % denominator != 0) {
                    continue;
                }

                long x = xNumerator / denominator;
                long y = yNumerator / denominator;

                points.add(new long[]{x, y});

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        int height = (int) (maxY - minY + 1);
        int width = (int) (maxX - minX + 1);

        char[][] board = new char[height][width];

        for (int row = 0; row < height; row++) {
            Arrays.fill(board[row], '.');
        }

        for (long[] point : points) {
            long x = point[0];
            long y = point[1];

            int row = (int) (maxY - y);
            int col = (int) (x - minX);

            board[row][col] = '*';
        }

        String[] answer = new String[height];

        for (int row = 0; row < height; row++) {
            answer[row] = new String(board[row]);
        }

        return answer;
    }
}