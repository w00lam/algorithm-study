import java.util.*;

class Solution {

    static class Node {
        int town;
        int cost;

        Node(int town, int cost) {
            this.town = town;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
            Comparator.comparingInt(node -> node.cost)
        );

        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.town]) {
                continue;
            }

            for (Node next : graph.get(current.town)) {
                int nextCost = current.cost + next.cost;

                if (nextCost < dist[next.town]) {
                    dist[next.town] = nextCost;
                    pq.offer(new Node(next.town, nextCost));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}