class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1;

        for (int i = 0; i < length; i++) {
            char ch = name.charAt(i);

            answer += Math.min(ch - 'A', 'Z' - ch + 1);

            int next = i + 1;

            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i * 2 + length - next);
            move = Math.min(move, i + (length - next) * 2);
        }

        return answer + move;
    }
}