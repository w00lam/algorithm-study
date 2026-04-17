import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
            .sorted(Comparator
                    .comparing((String s) -> s.charAt(n))
                    .thenComparing(s -> s)
                   )
            .toArray(String[]::new);
    }
}