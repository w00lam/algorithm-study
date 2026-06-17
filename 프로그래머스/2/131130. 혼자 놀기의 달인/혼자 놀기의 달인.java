import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSizes = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int current = i;
                int count = 0;

                while (!visited[current]) {
                    visited[current] = true;
                    count++;

                    current = cards[current] - 1;
                }

                groupSizes.add(count);
            }
        }

        if (groupSizes.size() < 2) {
            return 0;
        }

        Collections.sort(groupSizes, Collections.reverseOrder());

        return groupSizes.get(0) * groupSizes.get(1);
    }
}