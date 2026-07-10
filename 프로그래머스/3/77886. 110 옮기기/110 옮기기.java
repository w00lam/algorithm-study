class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            answer[i] = convert(s[i]);
        }

        return answer;
    }

    private String convert(String str) {
        StringBuilder stack = new StringBuilder();
        int count = 0;

        for (char c : str.toCharArray()) {
            stack.append(c);

            int len = stack.length();

            if (len >= 3
                    && stack.charAt(len - 3) == '1'
                    && stack.charAt(len - 2) == '1'
                    && stack.charAt(len - 1) == '0') {
                stack.delete(len - 3, len);
                count++;
            }
        }

        int insertIndex = stack.lastIndexOf("0") + 1;

        StringBuilder result = new StringBuilder();

        result.append(stack.substring(0, insertIndex));

        for (int i = 0; i < count; i++) {
            result.append("110");
        }

        result.append(stack.substring(insertIndex));

        return result.toString();
    }
}