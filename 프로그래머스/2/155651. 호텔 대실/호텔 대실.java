import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> {
            int startA = toMinute(a[0]);
            int startB = toMinute(b[0]);

            return startA - startB;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for (String[] book : book_time) {
            int start = toMinute(book[0]);
            int end = toMinute(book[1]) + 10;

            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
            answer = Math.max(answer, pq.size());
        }

        return answer;
    }

    private int toMinute(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));

        return hour * 60 + minute;
    }
}