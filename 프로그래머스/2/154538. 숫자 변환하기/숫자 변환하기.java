import java.util.*;


class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        queue.offer(new int[]{x, 0});
        visited[x] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int value = current[0];
            int count = current[1];
            
            if(value == y){
                return count;
            }
            
            int[] nextValues = {value + n, value * 2, value * 3};
            
            for(int next : nextValues){
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, count + 1});
                }
            }
        }
        
        return -1;
    }
}