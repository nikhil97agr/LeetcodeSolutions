package palindrome_permutation_ii_267;

import java.util.*;
class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> list = new ArrayList<>();
        int cnt[] = new int[26];
        int n = s.length();
        StringBuilder sb = new StringBuilder(" ".repeat(n));
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }
        if(n%2==0){
            for(int x : cnt){
                if(x%2==1) return list;
            }
        }
        if(n%2==1){
            int c = 0;
            for(int x : cnt){
                if(x%2==1){
                    c++;
                }
            }

            if(c > 1) return list;
        }
        solve(cnt,  0, n-1, sb, list);
        return list;
    }

    private void solve(int cnt[],  int start, int end,StringBuilder sb, List<String> result){
        if(start == end){
            for(char c = 'a';c<='z';c++){
                if(cnt[c-'a']!=0){
                    sb.setCharAt(start, c);
                    result.add(sb.toString());
                }
            }

            return;
        }

        if(start > end) {
            result.add(sb.toString());
            return;
        }

        for(char c = 'a';c<='z';c++){
            if(cnt[c-'a'] > 1){
                cnt[c-'a']-=2;

                sb.setCharAt(start, c);
                sb.setCharAt(end, c);

                solve(cnt, start+1, end - 1, sb, result);

                cnt[c-'a']+=2;
            }
        }
    }
}