class Solution {
    public int solution(int n, int k) {
        String converted = Integer.toString(n, k);
        String[] candidates = converted.split("0");
        
        int answer = 0;
        for (String candidate : candidates) {
            if (candidate.isEmpty()) {
                continue;
            }

            long num = Long.parseLong(candidate);

            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
    if (num < 2) return false;

    for (long i = 2; i * i <= num; i++) {
        if (num % i == 0) {
            return false;
        }
    }

    return true;
}
}