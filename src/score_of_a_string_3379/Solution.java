package score_of_a_string_3379;

class Solution {
    public int scoreOfString(String s) {
        int ans = 0;
        for(int i=0;i<s.length()-1;i++){
            ans += Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return ans;
    }
}