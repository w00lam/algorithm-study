import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while (stack.length() > 0 && stack.charAt(stack.length() - 1) < current && k > 0) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(current);
        }

        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        return stack.toString();
    }
}