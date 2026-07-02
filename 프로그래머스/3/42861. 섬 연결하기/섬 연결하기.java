import java.util.*;

class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        int answer = 0;
        int selected = 0;

        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int price = cost[2];

            if (find(from) != find(to)) {
                union(from, to);
                answer += price;
                selected++;

                if (selected == n - 1) {
                    break;
                }
            }
        }

        return answer;
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}