class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 4_000_000_000_000_000L;
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canTransport(mid, a, b, g, s, w, t)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canTransport(
            long time,
            int requiredGold,
            int requiredSilver,
            int[] gold,
            int[] silver,
            int[] capacity,
            int[] travelTime
    ) {
        long goldSum = 0;
        long silverSum = 0;
        long totalSum = 0;

        for (int i = 0; i < gold.length; i++) {
            long roundTripTime = 2L * travelTime[i];

            long transportCount = time / roundTripTime;

            if (time % roundTripTime >= travelTime[i]) {
                transportCount++;
            }

            long maxTransport =
                    transportCount * capacity[i];

            goldSum += Math.min(maxTransport, gold[i]);
            silverSum += Math.min(maxTransport, silver[i]);
            totalSum += Math.min(
                    maxTransport,
                    (long) gold[i] + silver[i]
            );
        }

        return goldSum >= requiredGold
                && silverSum >= requiredSilver
                && totalSum >= (long) requiredGold + requiredSilver;
    }
}