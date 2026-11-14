package substring_with_largest_variance_2360;

import java.util.*;
class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }
        ans = solve(s, s.length(), set, ans);
        s = new StringBuilder(s).reverse().toString();
        ans = solve(s, s.length(), set, ans);
        return ans;
    }

    private int solve(String s, int n, Set<Character> set , int ans){
        for(char c1 : set){
            for(char c2 : set){
                if(c1==c2) continue;
                int cnt1 = 0;
                int cnt2 = 0;
                for(char c : s.toCharArray()){
                    if(c==c1) cnt1++;
                    if(c==c2) cnt2++;

                    if(cnt2>cnt1) cnt1 = cnt2 = 0;

                    if(cnt1>0 && cnt2 > 0){
                        ans = Math.max(ans, cnt1 - cnt2);
                    }
                }
            }
        }
        return ans;
    }
}