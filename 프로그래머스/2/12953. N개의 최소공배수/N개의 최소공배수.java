class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            lcm = lcm * arr[i] / gcd(lcm, arr[i]);
        }
        
        return lcm;
    }
    
    private int gcd(int a, int b){
        while(b != 0){
            int temp = a;
            a = b;
            b = temp % b;
        }
        
        return a;
    }
}