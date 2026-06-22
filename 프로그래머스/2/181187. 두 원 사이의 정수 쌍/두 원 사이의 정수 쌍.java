class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        long r1Square = (long) r1 * r1;
        long r2Square = (long) r2 * r2;

        for (int x = 1; x <= r2; x++) {
            long xSquare = (long) x * x;

            long inner = r1Square - xSquare;

            long minY;
            if (inner <= 0) {
                minY = 1;
            } else {
                minY = (long) Math.ceil(Math.sqrt(inner));
            }

            long outer = r2Square - xSquare;
            long maxY = (long) Math.sqrt(outer);

            if (minY <= maxY) {
                answer += maxY - minY + 1;
            }
        }

        long axisCount = (long) (r2 - r1 + 1) * 4;

        return answer * 4 + axisCount;
    }
}