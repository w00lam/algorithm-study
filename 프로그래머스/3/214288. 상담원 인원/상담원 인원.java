import java.util.*;

class Solution {

    private int k;
    private int n;
    private int[][] reqs;

    private int[] mentorCount;
    private int answer = Integer.MAX_VALUE;

    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        this.reqs = reqs;
        this.mentorCount = new int[k];

        distributeMentors(0, 0);

        return answer;
    }

    private void distributeMentors(int typeIndex, int usedMentors) {
        if (typeIndex == k) {
            if (usedMentors == n) {
                int totalWaitTime = calculateWaitTime();
                answer = Math.min(answer, totalWaitTime);
            }

            return;
        }

        int remainingTypes = k - typeIndex - 1;
        int maxMentors = n - usedMentors - remainingTypes;

        for (int count = 1; count <= maxMentors; count++) {
            mentorCount[typeIndex] = count;

            distributeMentors(
                typeIndex + 1,
                usedMentors + count
            );
        }
    }

    private int calculateWaitTime() {
        int[][] endTimes = new int[k][];

        for (int type = 0; type < k; type++) {
            endTimes[type] = new int[mentorCount[type]];
        }

        int totalWaitTime = 0;

        for (int[] req : reqs) {
            int start = req[0];
            int duration = req[1];
            int type = req[2] - 1;

            int minIndex = findEarliestMentor(endTimes[type]);
            int earliestEndTime = endTimes[type][minIndex];

            if (earliestEndTime > start) {
                totalWaitTime += earliestEndTime - start;
                endTimes[type][minIndex] = earliestEndTime + duration;
            } else {
                endTimes[type][minIndex] = start + duration;
            }

            if (totalWaitTime >= answer) {
                return totalWaitTime;
            }
        }

        return totalWaitTime;
    }

    private int findEarliestMentor(int[] endTimes) {
        int minIndex = 0;

        for (int i = 1; i < endTimes.length; i++) {
            if (endTimes[i] < endTimes[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }
}