package rearrange_string_to_avoid_character_pair_4355;

class Solution {
    public String rearrangeString(String s, char x, char y) {
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        StringBuilder res = new StringBuilder();
        while(cnt[y - 'a'] > 0){
            res.append(y);
            cnt[y - 'a']--;
        }

        while(cnt[x- 'a'] > 0){
            res.append(x);
            cnt[x-'a']--;
        }

        for(char c = 'a';c <='z';c++){
            while(cnt[c-'a'] > 0){
                cnt[c-'a']--;
                res.append(c);
            }
        }

        return res.toString();

        
    }
}