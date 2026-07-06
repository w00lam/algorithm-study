class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int center = 0; center < s.length(); center++) {
            int oddLength = expand(s, center, center);       // 홀수 길이
            int evenLength = expand(s, center, center + 1);  // 짝수 길이

            answer = Math.max(answer, oddLength);
            answer = Math.max(answer, evenLength);
        }

        return answer;
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}