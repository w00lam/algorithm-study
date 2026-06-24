class Solution {
    private int[] discounts = {10, 20, 30, 40};
    private int[] selectedDiscounts;
    private int[] answer = new int[2];

    private int[][] users;
    private int[] emoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.selectedDiscounts = new int[emoticons.length];

        dfs(0);

        return answer;
    }

    private void dfs(int depth) {
        if (depth == emoticons.length) {
            calculate();
            return;
        }

        for (int discount : discounts) {
            selectedDiscounts[depth] = discount;
            dfs(depth + 1);
        }
    }

    private void calculate() {
        int plusCount = 0;
        int sales = 0;

        for (int i = 0; i < users.length; i++) {
            int userDiscountRate = users[i][0];
            int userLimitPrice = users[i][1];

            int sum = 0;

            for (int j = 0; j < emoticons.length; j++) {
                if (selectedDiscounts[j] >= userDiscountRate) {
                    sum += emoticons[j] * (100 - selectedDiscounts[j]) / 100;
                }
            }

            if (sum >= userLimitPrice) {
                plusCount++;
            } else {
                sales += sum;
            }
        }

        if (plusCount > answer[0]) {
            answer[0] = plusCount;
            answer[1] = sales;
        } else if (plusCount == answer[0] && sales > answer[1]) {
            answer[1] = sales;
        }
    }
}