package count_substrings_starting_and_ending_with_given_character_3337;

class Solution {
    public long countSubstrings(String s, char c) {
        long ans = 0;
        long cnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == c){
                cnt++;
            }
        }
        
        while(cnt > 0){
            ans += cnt;
            cnt--;
        }
        
        return ans;
    }
}