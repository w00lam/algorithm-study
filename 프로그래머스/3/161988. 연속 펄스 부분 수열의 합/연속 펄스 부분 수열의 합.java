class Solution {
    public long solution(int[] sequence) {
        long current1 = 0;
        long current2 = 0;
        long answer = Long.MIN_VALUE;

        for (int i = 0; i < sequence.length; i++) {
            long value1 = (i % 2 == 0) ? sequence[i] : -sequence[i];
            long value2 = -value1;

            current1 = Math.max(value1, current1 + value1);
            current2 = Math.max(value2, current2 + value2);

            answer = Math.max(answer, Math.max(current1, current2));
        }

        return answer;
    }
}