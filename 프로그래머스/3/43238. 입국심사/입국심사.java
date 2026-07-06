import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 0;
        long answer = 0;

        for (int time : times) {
            right = Math.max(right, time);
        }

        right *= n;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;

            for (int time : times) {
                count += mid / time;

                if (count >= n) {
                    break;
                }
            }

            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}