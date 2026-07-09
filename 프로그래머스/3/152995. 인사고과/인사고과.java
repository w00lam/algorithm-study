import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int rank = 1;
        int maxSecond = 0;

        for (int[] score : scores) {
            if (score[1] < maxSecond) {
                continue;
            }

            if (score[0] > wanho[0] && score[1] > wanho[1]) {
                return -1;
            }

            if (score[0] + score[1] > wanhoSum) {
                rank++;
            }

            maxSecond = Math.max(maxSecond, score[1]);
        }

        return rank;
    }
}