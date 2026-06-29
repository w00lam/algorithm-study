class Solution {

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int minDistance = Integer.MAX_VALUE;

            if (!(startY == targetY && startX > targetX)) {
                minDistance = Math.min(
                        minDistance,
                        distance(startX, startY, -targetX, targetY)
                );
            }

            if (!(startY == targetY && startX < targetX)) {
                minDistance = Math.min(
                        minDistance,
                        distance(startX, startY, 2 * m - targetX, targetY)
                );
            }

            if (!(startX == targetX && startY > targetY)) {
                minDistance = Math.min(
                        minDistance,
                        distance(startX, startY, targetX, -targetY)
                );
            }

            if (!(startX == targetX && startY < targetY)) {
                minDistance = Math.min(
                        minDistance,
                        distance(startX, startY, targetX, 2 * n - targetY)
                );
            }

            answer[i] = minDistance;
        }

        return answer;
    }

    private int distance(int startX, int startY, int targetX, int targetY) {
        int dx = targetX - startX;
        int dy = targetY - startY;

        return dx * dx + dy * dy;
    }
}