package maximum_length_substring_with_two_occurrences_3349;

class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int n = s.length();
        int start =0;
        int end = 0;
        int cnt[] = new int [26];

        do{
            char c = s.charAt(end);
            cnt[c-'a']++;
            while(cnt[c-'a'] > 2){
                char ch = s.charAt(start++);
                cnt[ch-'a']--;
            }

            ans = Math.max(ans, end- start + 1);
            
        }while(++end < n);

        return ans;

    }
}