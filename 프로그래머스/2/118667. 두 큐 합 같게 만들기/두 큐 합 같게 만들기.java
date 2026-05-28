class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        
        long total = 0;
        long queue1Sum = 0;
        long[] combined = new long[n * 2];
        
        for(int i = 0; i < n; i++){
            combined[i] = queue1[i];
            combined[i + n] = queue2[i];
            
            queue1Sum += queue1[i];
            total += queue1[i];
            total += queue2[i];
        }
        
        if(total % 2 != 0){
            return -1;
        }
        
        long target = total / 2;
        
        int left = 0;
        int right = n - 1;
        int count = 0;
        
        while(count <= 3 * n){
            if(queue1Sum == target){
                return count;
            }
            
            if(queue1Sum > target){
                queue1Sum -= combined[left];
                left++;
            } else {
                right++;
                
                if(right >= 2 * n){
                    break;
                }
                
                queue1Sum += combined[right];
            }
            
            count++;
        }
        
        return -1;
    }
}