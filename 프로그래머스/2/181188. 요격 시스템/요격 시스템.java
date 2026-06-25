import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int answer = 0;
        int intercept = Integer.MIN_VALUE;

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            if (start >= intercept) {
                answer++;
                intercept = end;
            }
        }

        return answer;
    }
}