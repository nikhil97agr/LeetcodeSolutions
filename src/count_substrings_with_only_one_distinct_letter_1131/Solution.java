package count_substrings_with_only_one_distinct_letter_1131;

class Solution {
    public int countLetters(String s) {
        int cnt = 0;
        char prev = s.charAt(0);
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c==prev)cnt++;
            else{
                prev = c;
                ans += (cnt*(cnt+1))>>1;
                cnt= 1;
            }
        }

        ans += (cnt*(cnt+1))>>1;
        return ans;
    }
}