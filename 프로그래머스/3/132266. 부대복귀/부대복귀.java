import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();

        distance[destination] = 0;
        queue.offer(destination);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (distance[next] != -1) {
                    continue;
                }

                distance[next] = distance[current] + 1;
                queue.offer(next);
            }
        }

        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }

        return answer;
    }
}