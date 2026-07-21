class Solution {

    public int[] solution(int e, int[] starts) {
        int[] divisorCount = new int[e + 1];

        for (int divisor = 1; divisor <= e; divisor++) {
            for (int multiple = divisor; multiple <= e; multiple += divisor) {
                divisorCount[multiple]++;
            }
        }

        int[] best = new int[e + 1];
        best[e] = e;

        for (int i = e - 1; i >= 1; i--) {
            int previousBest = best[i + 1];

            // 등장 횟수가 같으면 더 작은 숫자인 i를 선택
            if (divisorCount[i] >= divisorCount[previousBest]) {
                best[i] = i;
            } else {
                best[i] = previousBest;
            }
        }

        int[] answer = new int[starts.length];

        for (int i = 0; i < starts.length; i++) {
            answer[i] = best[starts[i]];
        }

        return answer;
    }
}