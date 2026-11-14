package keyboard_row_500;

import java.util.*;
class Solution {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();

        for(String s : words){
            if(check(s, "qwertyuiop") || check(s, "asdfghjkl") || check(s,"zxcvbnm" )){
                list.add(s);
            }
        }

        String ans[] = new String[list.size()];

        for(int i=0;i<list.size();i++) ans[i] = list.get(i);
        return ans;
    }

    private boolean check(String s, String key){
        int cnt[] = new int[26];
        for(char c : s.toLowerCase().toCharArray()) cnt[c-'a']++;

        for(char c :key.toCharArray()) cnt[c-'a'] = 0;

        for(int i=0;i<26;i++) if(cnt[i] !=0) return false;
        return true;
    }
}