import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] solution(int target) {
        List<int[]> scores = createScores();

        int[][] dp = new int[target + 1][2];

        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int currentScore = 1; currentScore <= target; currentScore++) {
            for (int[] dart : scores) {
                int score = dart[0];
                int singleOrBull = dart[1];

                if (score > currentScore) {
                    continue;
                }

                int previousScore = currentScore - score;

                if (dp[previousScore][0] == Integer.MAX_VALUE) {
                    continue;
                }

                int candidateCount = dp[previousScore][0] + 1;
                int candidateSingleOrBull =
                        dp[previousScore][1] + singleOrBull;

                if (candidateCount < dp[currentScore][0]
                        || (candidateCount == dp[currentScore][0]
                        && candidateSingleOrBull > dp[currentScore][1])) {

                    dp[currentScore][0] = candidateCount;
                    dp[currentScore][1] = candidateSingleOrBull;
                }
            }
        }

        return new int[]{dp[target][0], dp[target][1]};
    }

    private List<int[]> createScores() {
        List<int[]> scores = new ArrayList<>();

        for (int number = 1; number <= 20; number++) {
            scores.add(new int[]{number, 1});
            scores.add(new int[]{number * 2, 0});
            scores.add(new int[]{number * 3, 0});
        }

        scores.add(new int[]{50, 1});

        return scores;
    }
}