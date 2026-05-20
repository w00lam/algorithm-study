class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            long x = numbers[i];
            
            if(x % 2 == 0){
                answer[i] = x + 1;
            } else {
                long temp = x;
                int oneCount = 0;
                
                while ((temp & 1) == 1){
                    oneCount++;
                    temp >>= 1;
                }
                
                answer[i] = x + (1L << (oneCount - 1));
            }
        }
        
        return answer;
    }
}