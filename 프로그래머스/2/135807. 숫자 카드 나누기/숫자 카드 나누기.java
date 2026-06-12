class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        int gcdB = arrayB[0];

        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int candidateA = gcdA;

        for (int b : arrayB) {
            if (b % candidateA == 0) {
                candidateA = 0;
                break;
            }
        }

        int candidateB = gcdB;

        for (int a : arrayA) {
            if (a % candidateB == 0) {
                candidateB = 0;
                break;
            }
        }

        return Math.max(candidateA, candidateB);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}