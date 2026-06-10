class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (long x = 0; x <= d; x += k) {
            long yMax = (long) Math.sqrt((long) d * d - x * x);
            answer += yMax / k + 1;
        }

        return answer;
    }
}