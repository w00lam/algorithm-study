class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < food.length; i++){
            int cnt = food[i] / 2;
            sb.append(String.valueOf(i).repeat(cnt));
        }
        
        String answer = sb + "0";
        
        return answer += sb.reverse();
    }
}