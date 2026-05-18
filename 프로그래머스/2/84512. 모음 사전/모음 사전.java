class Solution {
    
    String[] vowels = {"A", "E", "I", "O", "U"};
    int count;
    int answer = 0;
    
    public int solution(String word) {
        dfs("", word);
        
        return answer;
    }
    
    private void dfs(String currentWord, String word){
        if(!currentWord.equals("")){
            count++;
        }
        if (currentWord.equals(word)) {
            answer = count;
        }
        if (currentWord.length() == 5) {
            return;
        }
        
        for (String vowel : vowels) {
            dfs(currentWord + vowel, word);
        }
    }
}