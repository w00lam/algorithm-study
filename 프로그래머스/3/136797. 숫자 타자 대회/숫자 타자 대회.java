import java.util.Arrays;

class Solution {

    private static final int INF = 1_000_000_000;

    private static final int[][] POSITION = {
        {3, 1},
        {0, 0},
        {0, 1},
        {0, 2},
        {1, 0},
        {1, 1},
        {1, 2},
        {2, 0},
        {2, 1},
        {2, 2}
    };

    public int solution(String numbers) {
        int[][] cost = createCost();

        int[][] dp = new int[10][10];
        fill(dp, INF);

        dp[4][6] = 0;

        for (char number : numbers.toCharArray()) {
            int target = number - '0';

            int[][] nextDp = new int[10][10];
            fill(nextDp, INF);

            for (int left = 0; left < 10; left++) {
                for (int right = 0; right < 10; right++) {
                    if (dp[left][right] == INF) {
                        continue;
                    }

                    int currentCost = dp[left][right];

                    if (left == target) {
                        nextDp[left][right] = Math.min(
                            nextDp[left][right],
                            currentCost + 1
                        );
                        continue;
                    }

                    if (right == target) {
                        nextDp[left][right] = Math.min(
                            nextDp[left][right],
                            currentCost + 1
                        );
                        continue;
                    }

                    nextDp[target][right] = Math.min(
                        nextDp[target][right],
                        currentCost + cost[left][target]
                    );

                    nextDp[left][target] = Math.min(
                        nextDp[left][target],
                        currentCost + cost[right][target]
                    );
                }
            }

            dp = nextDp;
        }

        int answer = INF;

        for (int left = 0; left < 10; left++) {
            for (int right = 0; right < 10; right++) {
                answer = Math.min(answer, dp[left][right]);
            }
        }

        return answer;
    }

    private int[][] createCost() {
        int[][] cost = new int[10][10];

        for (int from = 0; from < 10; from++) {
            for (int to = 0; to < 10; to++) {
                if (from == to) {
                    cost[from][to] = 1;
                    continue;
                }

                int rowDiff = Math.abs(
                    POSITION[from][0] - POSITION[to][0]
                );
                int colDiff = Math.abs(
                    POSITION[from][1] - POSITION[to][1]
                );

                int diagonalCount = Math.min(rowDiff, colDiff);
                int straightCount = Math.abs(rowDiff - colDiff);

                cost[from][to]
                    = diagonalCount * 3
                    + straightCount * 2;
            }
        }

        return cost;
    }

    private void fill(int[][] array, int value) {
        for (int[] row : array) {
            Arrays.fill(row, value);
        }
    }
}