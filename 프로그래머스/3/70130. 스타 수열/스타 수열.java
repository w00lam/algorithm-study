class Solution {

    public int solution(int[] a) {
        int[] count = new int[a.length];

        for (int value : a) {
            count[value]++;
        }

        int maxPair = 0;

        for (int k = 0; k < count.length; k++) {
            if (count[k] <= maxPair) {
                continue;
            }

            int pairCount = 0;
            int i = 0;

            while (i + 1 < a.length) {
                boolean containsK = a[i] == k || a[i + 1] == k;
                boolean different = a[i] != a[i + 1];

                if (containsK && different) {
                    pairCount++;
                    i += 2;
                } else {
                    i++;
                }
            }

            maxPair = Math.max(maxPair, pairCount);
        }

        return maxPair * 2;
    }
}