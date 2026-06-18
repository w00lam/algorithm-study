class Solution {
    private String[] minerals;
    private int answer;

    public int solution(int[] picks, String[] minerals) {
        this.minerals = minerals;
        this.answer = Integer.MAX_VALUE;

        dfs(0, picks, 0);

        return answer;
    }

    private void dfs(int index, int[] picks, int fatigue) {
        if (index >= minerals.length) {
            answer = Math.min(answer, fatigue);
            return;
        }

        boolean usedPick = false;

        for (int pick = 0; pick < 3; pick++) {
            if (picks[pick] == 0) {
                continue;
            }

            usedPick = true;

            int cost = calculateCost(pick, index);

            picks[pick]--;
            dfs(index + 5, picks, fatigue + cost);
            picks[pick]++;
        }

        if (!usedPick) {
            answer = Math.min(answer, fatigue);
        }
    }

    private int calculateCost(int pick, int index) {
        int cost = 0;

        for (int i = index; i < index + 5 && i < minerals.length; i++) {
            cost += getFatigue(pick, minerals[i]);
        }

        return cost;
    }

    private int getFatigue(int pick, String mineral) {
        if (pick == 0) {
            return 1;
        }

        if (pick == 1) {
            if (mineral.equals("diamond")) {
                return 5;
            }

            return 1;
        }

        if (mineral.equals("diamond")) {
            return 25;
        }

        if (mineral.equals("iron")) {
            return 5;
        }

        return 1;
    }
}