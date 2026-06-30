import java.util.*;

class Solution {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minPq.add(number);
                maxPq.add(number);
                countMap.put(number, countMap.getOrDefault(number, 0) + 1);
                continue;
            }

            if (number == 1) {
                delete(maxPq, countMap);
            } else {
                delete(minPq, countMap);
            }
        }

        clean(minPq, countMap);
        clean(maxPq, countMap);

        if (minPq.isEmpty() || maxPq.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxPq.peek(), minPq.peek()};
    }

    private void delete(PriorityQueue<Integer> pq, Map<Integer, Integer> countMap) {
        clean(pq, countMap);

        if (pq.isEmpty()) {
            return;
        }

        int value = pq.poll();
        countMap.put(value, countMap.get(value) - 1);
    }

    private void clean(PriorityQueue<Integer> pq, Map<Integer, Integer> countMap) {
        while (!pq.isEmpty() && countMap.getOrDefault(pq.peek(), 0) == 0) {
            pq.poll();
        }
    }
}