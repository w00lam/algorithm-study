import java.util.stream.IntStream;

class Solution {
    public int solution(int number, int limit, int power) {
        
        return IntStream.rangeClosed(1, number)
                .map(i -> countDivisors(i))
                .map(cnt -> cnt > limit ? power : cnt)
                .sum();
    }
    
    private int countDivisors(int n){
        int count = 0;
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            if (i * i == n) {
                count++;
            } else {
                count += 2;
            }
        }
        }
        return count;
    }
}