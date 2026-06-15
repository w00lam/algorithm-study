import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] count = new long[1001];
        int[] distances = {2, 3, 4};

        for (int w : weights) {
            Set<Integer> candidates = new HashSet<>();

            for (int currentDistance : distances) {
                for (int previousDistance : distances) {
                    int torque = w * currentDistance;

                    if (torque % previousDistance == 0) {
                        int candidate = torque / previousDistance;

                        if (candidate >= 100 && candidate <= 1000) {
                            candidates.add(candidate);
                        }
                    }
                }
            }

            for (int candidate : candidates) {
                answer += count[candidate];
            }

            count[w]++;
        }

        return answer;
    }
}