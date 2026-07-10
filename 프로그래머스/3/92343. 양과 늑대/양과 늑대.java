import java.util.*;

class Solution {

    private List<Integer>[] graph;
    private int[] info;
    private int answer = 0;

    public int solution(int[] info, int[][] edges) {
        this.info = info;

        graph = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            graph[parent].add(child);
        }

        List<Integer> candidates = new ArrayList<>();
        candidates.addAll(graph[0]);

        dfs(0, 0, 0, candidates);

        return answer;
    }

    private void dfs(int node, int sheep, int wolf, List<Integer> candidates) {
        if (info[node] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (wolf >= sheep) {
            return;
        }

        answer = Math.max(answer, sheep);

        for (int next : candidates) {
            List<Integer> nextCandidates = new ArrayList<>(candidates);

            nextCandidates.remove(Integer.valueOf(next));
            nextCandidates.addAll(graph[next]);

            dfs(next, sheep, wolf, nextCandidates);
        }
    }
}