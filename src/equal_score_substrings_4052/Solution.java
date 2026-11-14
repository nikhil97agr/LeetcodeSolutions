package equal_score_substrings_4052;

class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        for(int i=0;i<n-1;i++){
            int score = 0;

            for(int j=0;j<=i;j++){
                score += ((s.charAt(j)-'a')+1);
            }

            for(int j=i+1;j<n;j++){
                score -= ((s.charAt(j)-'a')+1);
            }
            if(score == 0) return true;
        }

        return false;
    }
}