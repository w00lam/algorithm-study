import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer>[] graph;
    private int[][] dp;

    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : lighthouse) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, 0);

        return Math.min(dp[1][0], dp[1][1]);
    }

    private void dfs(int current, int parent) {
        dp[current][0] = 0;
        dp[current][1] = 1;

        for (int next : graph[current]) {
            if (next == parent) {
                continue;
            }

            dfs(next, current);

            dp[current][0] += dp[next][1];

            dp[current][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}