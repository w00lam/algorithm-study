import java.util.*;

class Solution {
    private String[][] tickets;
    private boolean[] visited;
    private List<String> route;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.visited = new boolean[tickets.length];
        this.route = new ArrayList<>();

        Arrays.sort(this.tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        route.add("ICN");

        dfs("ICN");

        return route.toArray(new String[0]);
    }

    private boolean dfs(String currentAirport) {
        if (route.size() == tickets.length + 1) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (!tickets[i][0].equals(currentAirport)) {
                continue;
            }

            visited[i] = true;
            route.add(tickets[i][1]);

            if (dfs(tickets[i][1])) {
                return true;
            }

            visited[i] = false;
            route.remove(route.size() - 1);
        }

        return false;
    }
}