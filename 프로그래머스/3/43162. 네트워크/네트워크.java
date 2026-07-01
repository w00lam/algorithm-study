class Solution {
    int n;
    int[][] computers;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    private void dfs(int current) {
        visited[current] = true;

        for (int next = 0; next < n; next++) {
            if (computers[current][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }
}