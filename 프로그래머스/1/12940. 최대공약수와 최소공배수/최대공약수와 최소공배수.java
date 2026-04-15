class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        int lcm = (n * m) / gcd;
        
        int[] answer = {gcd, lcm};
        
        return answer;
    }
    
    private int getGCD(int n, int m){
        if(n % m == 0){
            return m;
        }
        
        return getGCD(m, n % m);
    }
}