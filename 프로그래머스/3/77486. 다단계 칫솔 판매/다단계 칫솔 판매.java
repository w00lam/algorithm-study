import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            indexMap.put(enroll[i], i);
        }

        int[] parent = new int[enroll.length];

        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = indexMap.get(referral[i]);
            }
        }

        int[] answer = new int[enroll.length];

        for (int i = 0; i < seller.length; i++) {
            int current = indexMap.get(seller[i]);
            int money = amount[i] * 100;

            while (current != -1 && money > 0) {
                int give = money / 10;
                answer[current] += money - give;

                current = parent[current];
                money = give;
            }
        }

        return answer;
    }
}