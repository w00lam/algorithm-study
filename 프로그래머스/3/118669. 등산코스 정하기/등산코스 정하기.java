import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int cost = path[2];

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];

        for (int gate : gates) {
            isGate[gate] = true;
        }

        for (int summit : summits) {
            isSummit[summit] = true;
        }

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<State> queue =
                new PriorityQueue<>(Comparator.comparingInt(state -> state.intensity));

        for (int gate : gates) {
            intensity[gate] = 0;
            queue.offer(new State(gate, 0));
        }

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.intensity > intensity[current.node]) {
                continue;
            }

            if (isSummit[current.node]) {
                continue;
            }

            for (Edge edge : graph[current.node]) {
                int nextNode = edge.to;

                if (isGate[nextNode]) {
                    continue;
                }

                int nextIntensity =
                        Math.max(current.intensity, edge.cost);

                if (nextIntensity < intensity[nextNode]) {
                    intensity[nextNode] = nextIntensity;
                    queue.offer(new State(nextNode, nextIntensity));
                }
            }
        }

        Arrays.sort(summits);

        int answerSummit = 0;
        int minIntensity = Integer.MAX_VALUE;

        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                answerSummit = summit;
                minIntensity = intensity[summit];
            }
        }

        return new int[]{answerSummit, minIntensity};
    }

    private static class Edge {
        private final int to;
        private final int cost;

        private Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class State {
        private final int node;
        private final int intensity;

        private State(int node, int intensity) {
            this.node = node;
            this.intensity = intensity;
        }
    }
}