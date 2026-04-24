class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] patterns = {"aya", "ye", "woo", "ma"};
        
        for(String word : babbling){
            int idx = 0;
            String prev = "";
            boolean valid = true;
            
            while (idx < word.length()) {
                boolean matched = false;

                for (String p : patterns) {
                    if (word.startsWith(p, idx)) {
                        if (prev.equals(p)) {
                            valid = false;
                            break;
                        }
                        
                        prev = p;
                        idx += p.length();
                        matched = true;
                        break;
                    }
                }
                
                if (!matched) {
                    valid = false;
                    break;
                }

                if (!valid) break;
            }

            if (valid && idx == word.length()) {
                answer++;
            }
        }
        return answer;
    }
}