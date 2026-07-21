class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long minX = x;
        long maxX = x;
        long minY = y;
        long maxY = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int command = queries[i][0];
            long distance = queries[i][1];

            switch (command) {
                case 0:
                    if (minY != 0) {
                        minY += distance;
                    }

                    maxY = Math.min(m - 1L, maxY + distance);
                    break;
                case 1:
                    minY = Math.max(0, minY - distance);

                    if (maxY != m - 1L) {
                        maxY -= distance;
                    }
                    break;
                case 2:
                    if (minX != 0) {
                        minX += distance;
                    }

                    maxX = Math.min(n - 1L, maxX + distance);
                    break;
                case 3:
                    minX = Math.max(0, minX - distance);

                    if (maxX != n - 1L) {
                        maxX -= distance;
                    }
                    break;
            }

            if (minX > maxX || minY > maxY) {
                return 0;
            }
        }

        long rowCount = maxX - minX + 1;
        long columnCount = maxY - minY + 1;

        return rowCount * columnCount;
    }
}