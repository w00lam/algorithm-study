import java.util.*;

class Solution {
    private boolean[][] visited;
    private String[] maps;
    private int rows;
    private int cols;
    
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] inputMaps) {
        this.maps = inputMaps;
        this.rows = maps.length;
        this.cols = maps[0].length();
        
        visited = new boolean[rows][cols];
        
        List<Integer> result = new ArrayList<>();
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(!visited[row][col] && maps[row].charAt(col) != 'X'){
                    int food = dfs(row, col);
                    result.add(food);
                }
            }
        }
        
        if (result.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(result);
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    private int dfs(int row, int col){
        if(row < 0 || row >= rows || col < 0 || col >= cols) return 0;
        if(visited[row][col] || maps[row].charAt(col) == 'X') return 0;
        
        visited[row][col] = true;
        
        int sum = maps[row].charAt(col) - '0';
        
        for(int i = 0; i < 4; i++){
            sum += dfs(row + dr[i], col + dc[i]);
        }
        
        return sum;
    }
}