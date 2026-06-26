class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        long deliveryNeed = 0;
        long pickupNeed = 0;

        for (int i = n - 1; i >= 0; i--) {
            deliveryNeed += deliveries[i];
            pickupNeed += pickups[i];

            while (deliveryNeed > 0 || pickupNeed > 0) {
                deliveryNeed -= cap;
                pickupNeed -= cap;
                answer += (i + 1) * 2L;
            }
        }

        return answer;
    }
}