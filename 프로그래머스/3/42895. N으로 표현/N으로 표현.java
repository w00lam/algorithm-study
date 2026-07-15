import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        int connectedNumber = 0;

        for (int i = 1; i <= 8; i++) {
            connectedNumber = connectedNumber * 10 + N;
            dp.get(i).add(connectedNumber);

            for (int j = 1; j < i; j++) {
                Set<Integer> leftSet = dp.get(j);
                Set<Integer> rightSet = dp.get(i - j);

                for (int left : leftSet) {
                    for (int right : rightSet) {
                        dp.get(i).add(left + right);
                        dp.get(i).add(left - right);
                        dp.get(i).add(left * right);

                        if (right != 0) {
                            dp.get(i).add(left / right);
                        }
                    }
                }
            }

            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}