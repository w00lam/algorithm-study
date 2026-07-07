import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = Integer.MAX_VALUE;
        rightMin[n - 1] = Integer.MAX_VALUE;

        int min = a[0];

        for (int i = 1; i < n; i++) {
            leftMin[i] = min;
            min = Math.min(min, a[i]);
        }

        min = a[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = min;
            min = Math.min(min, a[i]);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (leftMin[i] > a[i] || rightMin[i] > a[i]) {
                answer++;
            }
        }

        return answer;
    }
}