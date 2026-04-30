import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {   
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            indexMap.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = indexMap.get(calling);

            String frontPlayer = players[idx - 1];

            players[idx - 1] = calling;
            players[idx] = frontPlayer;

            indexMap.put(calling, idx - 1);
            indexMap.put(frontPlayer, idx);
        }
        
        return players;
    }
}