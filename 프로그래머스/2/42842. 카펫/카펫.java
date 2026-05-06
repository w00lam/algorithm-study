class Solution {
    public int[] solution(int brown, int yellow) {
        for(int a = 1; a * a <= yellow; a++){
            if(yellow % a == 0){
                int b = yellow / a;
                
                int h = a + 2;
                int w = b + 2;
                
                if( w * h == brown + yellow){
                return new int[]{w, h};
            }
            }
        }
        
        return new int[0];
    }
}