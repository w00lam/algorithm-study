class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = Math.abs(x - r) + Math.abs(y - c);

        if (distance > k || (k - distance) % 2 != 0) {
            return "impossible";
        }

        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};
        char[] directions = {'d', 'l', 'r', 'u'};

        int currentRow = x;
        int currentCol = y;

        StringBuilder answer = new StringBuilder();

        for (int move = 0; move < k; move++) {
            int remain = k - move - 1;

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + dr[i];
                int nextCol = currentCol + dc[i];

                if (nextRow < 1 || nextRow > n
                        || nextCol < 1 || nextCol > m) {
                    continue;
                }

                int nextDistance =
                        Math.abs(nextRow - r) + Math.abs(nextCol - c);

                if (nextDistance <= remain
                        && (remain - nextDistance) % 2 == 0) {

                    currentRow = nextRow;
                    currentCol = nextCol;
                    answer.append(directions[i]);
                    break;
                }
            }
        }

        return answer.toString();
    }
}