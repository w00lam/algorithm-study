import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];

        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = value++;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(matrix, queries[i]);
        }

        return answer;
    }

    private int rotate(int[][] matrix, int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int temp = matrix[x1][y1];
        int min = temp;

        for (int row = x1; row < x2; row++) {
            matrix[row][y1] = matrix[row + 1][y1];
            min = Math.min(min, matrix[row][y1]);
        }

        for (int col = y1; col < y2; col++) {
            matrix[x2][col] = matrix[x2][col + 1];
            min = Math.min(min, matrix[x2][col]);
        }

        for (int row = x2; row > x1; row--) {
            matrix[row][y2] = matrix[row - 1][y2];
            min = Math.min(min, matrix[row][y2]);
        }

        for (int col = y2; col > y1 + 1; col--) {
            matrix[x1][col] = matrix[x1][col - 1];
            min = Math.min(min, matrix[x1][col]);
        }

        matrix[x1][y1 + 1] = temp;

        return min;
    }
}