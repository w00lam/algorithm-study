class Solution {
    public int solution(int n, long l, long r) {
        long answer = 0;

        long start = l - 1;
        long end = r - 1;

        for (long i = start; i <= end; i++) {
            if (isOne(i)) {
                answer++;
            }
        }

        return (int) answer;
    }

    private boolean isOne(long index) {
        while (index > 0) {
            if (index % 5 == 2) {
                return false;
            }

            index /= 5;
        }

        return true;
    }
}