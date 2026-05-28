class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        int answerLeft = 0;
        int answerRight = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < sequence.length) {
            if (sum == k) {
                int currentLength = right - left + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    answerLeft = left;
                    answerRight = right;
                }
}
            if (sum >= k) {
                sum -= sequence[left];
                left++;
            } else {
                right++;

                if (right == sequence.length) {
                    break;
                }

            sum += sequence[right];
            }
        }

        return new int[]{answerLeft, answerRight};
    }
}