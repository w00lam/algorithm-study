class Solution {
    public long solution(int w, int h) {
        long total = (long) w * h;
        long unusable = (long) w + h - gcd(w, h);

        return total - unusable;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}