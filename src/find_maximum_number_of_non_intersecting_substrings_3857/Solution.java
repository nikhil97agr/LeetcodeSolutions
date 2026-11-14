package find_maximum_number_of_non_intersecting_substrings_3857;

import java.util.*;
class Solution {
    public int maxSubstrings(String word) {
        List<Integer> list[] = new ArrayList[26];
        for(int i=0;i<26;i++) list[i] = new ArrayList<>();
        int n = word.length();
        int dp[] = new int[n+1];

        for(int i=0;i<n;i++){
            int ind = word.charAt(i) - 'a';
            dp[i+1] = dp[i];
            for(int j : list[ind]){
                if(i-j + 1 >= 4){
                    dp[i+1] = Math.max(dp[i+1], dp[j]+1);
                }
            }

            list[ind].add(i);
            if(list[ind].size() > 4){
                list[ind].remove(0);
            }
        }

        return dp[n];
    }

}