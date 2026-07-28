class Solution {

    private static final long MOD = 1_000_000_007L;

    public int solution(int n) {
        long[] dp = new long[n + 1];

        dp[0] = 1;

        if (n >= 1) {
            dp[1] = 1;
        }

        if (n >= 2) {
            dp[2] = 3;
        }

        if (n >= 3) {
            dp[3] = 10;
        }

        long[] remainderSum = new long[3];
        long totalSum = 0;

        for (int i = 4; i <= n; i++) {
            int index = i - 4;

            remainderSum[index % 3]
                    = (remainderSum[index % 3] + dp[index]) % MOD;

            totalSum = (totalSum + dp[index]) % MOD;

            long sameRemainder = remainderSum[i % 3];
            long otherRemainders = (totalSum - sameRemainder + MOD) % MOD;

            long extra = (
                    4L * sameRemainder
                    + 2L * otherRemainders
            ) % MOD;

            dp[i] = (
                    dp[i - 1]
                    + 2L * dp[i - 2]
                    + 5L * dp[i - 3]
                    + extra
            ) % MOD;
        }

        return (int) dp[n];
    }
}