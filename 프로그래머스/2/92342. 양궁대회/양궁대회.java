import java.util.*;

class Solution {
    private int[] apeach;
    private int[] ryan = new int[11];
    private int[] answer = {-1};
    private int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        this.apeach = info;

        dfs(0, n);

        return answer;
    }

    private void dfs(int idx, int arrowsLeft) {
        if (idx == 11) {
            ryan[10] += arrowsLeft;

            evaluate();

            ryan[10] -= arrowsLeft;
            return;
        }

        int need = apeach[idx] + 1;

        if (arrowsLeft >= need) {
            ryan[idx] = need;
            dfs(idx + 1, arrowsLeft - need);
            ryan[idx] = 0;
        }

        dfs(idx + 1, arrowsLeft);
    }

    private void evaluate() {
        int ryanScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < 11; i++) {
            int score = 10 - i;

            if (ryan[i] > apeach[i]) {
                ryanScore += score;
            } else if (apeach[i] > 0) {
                apeachScore += score;
            }
        }

        int diff = ryanScore - apeachScore;

        if (diff <= 0) {
            return;
        }

        if (diff > maxDiff) {
            maxDiff = diff;
            answer = ryan.clone();
            return;
        }

        if (diff == maxDiff && isBetterLowScore()) {
            answer = ryan.clone();
        }
    }

    private boolean isBetterLowScore() {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] > answer[i]) {
                return true;
            }

            if (ryan[i] < answer[i]) {
                return false;
            }
        }

        return false;
    }
}