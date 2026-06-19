import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> numbers = new ArrayList<>();

        int num = k;
        numbers.add(num);

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }

            numbers.add(num);
        }

        int n = numbers.size() - 1;

        double[] areas = new double[n];

        for (int i = 0; i < n; i++) {
            areas[i] = (numbers.get(i) + numbers.get(i + 1)) / 2.0;
        }

        double[] prefix = new double[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + areas[i];
        }

        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];

            if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefix[end] - prefix[start];
            }
        }

        return answer;
    }
}