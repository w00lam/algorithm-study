import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> holes = extractShapes(game_board, 0);
        List<List<int[]>> pieces = extractShapes(table, 1);

        boolean[] used = new boolean[pieces.size()];
        int answer = 0;

        for (List<int[]> hole : holes) {
            for (int i = 0; i < pieces.size(); i++) {
                if (used[i]) {
                    continue;
                }

                List<int[]> piece = pieces.get(i);

                if (hole.size() != piece.size()) {
                    continue;
                }

                if (canMatch(hole, piece)) {
                    used[i] = true;
                    answer += hole.size();
                    break;
                }
            }
        }

        return answer;
    }

    private List<List<int[]>> extractShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col] && board[row][col] == target) {
                    List<int[]> shape = new ArrayList<>();

                    dfs(board, row, col, target, visited, shape);

                    shapes.add(normalize(shape));
                }
            }
        }

        return shapes;
    }

    private void dfs(
            int[][] board,
            int row,
            int col,
            int target,
            boolean[][] visited,
            List<int[]> shape
    ) {
        visited[row][col] = true;
        shape.add(new int[]{row, col});

        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + DR[direction];
            int nextCol = col + DC[direction];

            if (nextRow < 0 || nextRow >= board.length
                    || nextCol < 0 || nextCol >= board.length) {
                continue;
            }

            if (visited[nextRow][nextCol]) {
                continue;
            }

            if (board[nextRow][nextCol] != target) {
                continue;
            }

            dfs(board, nextRow, nextCol, target, visited, shape);
        }
    }

    private boolean canMatch(List<int[]> hole, List<int[]> piece) {
        List<int[]> rotatedPiece = copyShape(piece);

        for (int rotation = 0; rotation < 4; rotation++) {
            rotatedPiece = normalize(rotatedPiece);

            if (isSameShape(hole, rotatedPiece)) {
                return true;
            }

            rotatedPiece = rotate(rotatedPiece);
        }

        return false;
    }

    private List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();

        for (int[] point : shape) {
            int row = point[0];
            int col = point[1];

            rotated.add(new int[]{col, -row});
        }

        return normalize(rotated);
    }

    private List<int[]> normalize(List<int[]> shape) {
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;

        for (int[] point : shape) {
            minRow = Math.min(minRow, point[0]);
            minCol = Math.min(minCol, point[1]);
        }

        List<int[]> normalized = new ArrayList<>();

        for (int[] point : shape) {
            normalized.add(new int[]{
                    point[0] - minRow,
                    point[1] - minCol
            });
        }

        normalized.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        return normalized;
    }

    private boolean isSameShape(List<int[]> first, List<int[]> second) {
        if (first.size() != second.size()) {
            return false;
        }

        for (int i = 0; i < first.size(); i++) {
            int[] firstPoint = first.get(i);
            int[] secondPoint = second.get(i);

            if (firstPoint[0] != secondPoint[0]
                    || firstPoint[1] != secondPoint[1]) {
                return false;
            }
        }

        return true;
    }

    private List<int[]> copyShape(List<int[]> shape) {
        List<int[]> copied = new ArrayList<>();

        for (int[] point : shape) {
            copied.add(new int[]{point[0], point[1]});
        }

        return copied;
    }
}