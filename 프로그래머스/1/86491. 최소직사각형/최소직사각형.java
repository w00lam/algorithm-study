class Solution {
    public int solution(int[][] sizes) {
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;

        for (int[] card : sizes) {
            int w = Math.max(card[0], card[1]);
            int h = Math.min(card[0], card[1]);

            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }

        return maxW * maxH;
    }
}