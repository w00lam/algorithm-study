class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] arr = new int[n][n];

        int row = -1;
        int col = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (i % 3 == 0) {
                    row++;
                } else if (i % 3 == 1) {
                    col++;
                } else {
                    row--;
                    col--;
                }

                arr[row][col] = num++;
            }
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    }
}