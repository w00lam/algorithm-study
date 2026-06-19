import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long soldiers = n;

        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);

            if (pq.size() > k) {
                soldiers -= pq.poll();
            }

            if (soldiers < 0) {
                return i;
            }
        }

        return enemy.length;
    }
}