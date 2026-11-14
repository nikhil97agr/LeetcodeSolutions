package substrings_that_begin_and_end_with_the_same_letter_2225;

class Solution {
    public long numberOfSubstrings(String s) {
        long ans = 0;
        int cnt [] = new int[26];

        for(char c : s.toCharArray()){
            cnt[c-'a']++;
            ans += cnt[c-'a'];
        }

        return ans;
    }
}