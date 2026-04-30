class Solution {
    
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};
    private final char[] dirs = {'N', 'S', 'W', 'E'};
    
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        
        int[] pos = findStart(park);
        
        
        for (String route : routes) {
            String[] parts = route.split(" ");
            char dir = parts[0].charAt(0);
            int dist = Integer.parseInt(parts[1]);

            int dirIdx = getDirIndex(dir);

            if (canMove(park, pos[0], pos[1], dirIdx, dist, h, w)) {
                pos[0] += dr[dirIdx] * dist;
                pos[1] += dc[dirIdx] * dist;
            }
        }

        return pos;
    }
    
    private int[] findStart(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
    
    private int getDirIndex(char dir) {
        for (int i = 0; i < 4; i++) {
            if (dirs[i] == dir) return i;
        }
        return -1;
    }
    
    private boolean canMove(String[] park, int r, int c, int dirIdx, int dist, int h, int w) {
        int nr = r;
        int nc = c;

        for (int i = 0; i < dist; i++) {
            nr += dr[dirIdx];
            nc += dc[dirIdx];

            if (nr < 0 || nr >= h || nc < 0 || nc >= w) return false;
            if (park[nr].charAt(nc) == 'X') return false;
        }

        return true;
    }
}