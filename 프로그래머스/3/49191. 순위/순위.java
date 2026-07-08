import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        List<Integer>[] winGraph = new ArrayList[n + 1];
        List<Integer>[] loseGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            winGraph[winner].add(loser);
            loseGraph[loser].add(winner);
        }

        int answer = 0;

        for (int player = 1; player <= n; player++) {
            int winCount = bfs(player, winGraph);
            int loseCount = bfs(player, loseGraph);

            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int bfs(int start, List<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.offer(next);
                count++;
            }
        }

        return count;
    }
}