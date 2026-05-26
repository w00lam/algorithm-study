class Solution {
    int[] answer = new int[2];
    int[][] arr;
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
        
        dfs(0,0,arr.length);
        
        return answer;
    }
    
    public void dfs(int row, int col, int size){
        int base = arr[row][col];
        
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if (arr[i][j] != base) {
                    int nextSize = size / 2;

                    dfs(row, col, nextSize);
                    dfs(row, col + nextSize, nextSize);
                    dfs(row + nextSize, col, nextSize);
                    dfs(row + nextSize, col + nextSize, nextSize);

                    return;
                }
            }
        }
        
        answer[base]++;
    }
}