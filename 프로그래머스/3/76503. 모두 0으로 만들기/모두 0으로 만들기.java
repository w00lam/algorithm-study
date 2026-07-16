import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public long solution(int[] a, int[][] edges) {
        int n = a.length;

        long[] weight = new long[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            weight[i] = a[i];
            total += a[i];
        }

        if (total != 0) {
            return -1;
        }

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph[from].add(to);
            graph[to].add(from);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int[] order = new int[n];
        int orderIndex = 0;

        int[] stack = new int[n];
        int top = 0;

        parent[0] = 0;
        stack[top++] = 0;

        while (top > 0) {
            int current = stack[--top];
            order[orderIndex++] = current;

            for (int next : graph[current]) {
                if (parent[next] != -1) {
                    continue;
                }

                parent[next] = current;
                stack[top++] = next;
            }
        }

        long answer = 0;

        for (int i = n - 1; i > 0; i--) {
            int current = order[i];
            int parentNode = parent[current];

            answer += Math.abs(weight[current]);
            weight[parentNode] += weight[current];
        }

        return answer;
    }
}