import java.util.*;

class Solution {
    private List<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int cutA = wire[0];
            int cutB = wire[1];

            boolean[] visited = new boolean[n + 1];

            int count = dfs(1, cutA, cutB, visited);

            int other = n - count;
            int diff = Math.abs(count - other);

            answer = Math.min(answer, diff);
        }

        return answer;
    }
    
    private int dfs(int current, int cutA, int cutB, boolean[] visited) {
        visited[current] = true;

        int count = 1;

        for (int next : graph[current]) {
            if ((current == cutA && next == cutB) ||
                (current == cutB && next == cutA)) {
                continue;
            }
            
            if (visited[next]) {
                continue;
            }
            
            count += dfs(next, cutA, cutB, visited);
        }

        return count;
    }
}