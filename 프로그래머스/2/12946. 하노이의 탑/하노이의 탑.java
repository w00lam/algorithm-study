import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<int[]> moves;

    public int[][] solution(int n) {
        moves = new ArrayList<>();

        move(n, 1, 3, 2);

        int[][] answer = new int[moves.size()][2];

        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }

        return answer;
    }

    private void move(int n, int from, int to, int via) {
        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }

        move(n - 1, from, via, to);
        moves.add(new int[]{from, to});
        move(n - 1, via, to, from);
    }
}