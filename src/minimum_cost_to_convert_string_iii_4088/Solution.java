package minimum_cost_to_convert_string_iii_4088;

import java.util.*;
class Solution {
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        var n = source.length();

        if(source.length() != target.length()) return -1;

        var m = rules.size();
        var length = new int[m];
        int modifiedCost[] = new int[m];
        for(int i=0;i<m;i++){
            int wild = 0;
            var pattern = rules.get(i).get(0);

            for(char c : pattern.toCharArray()){
                if(c == '*'){
                    wild++;
                }
            }

            modifiedCost[i] = costs[i] + wild;
            length[i] = pattern.length();
            
        }

        long dp[] = new long[n + 1];

        Arrays.fill(dp, Long.MAX_VALUE);

        dp[n] = 0;

        for(int i=n-1;i>=0;i--){
            if(source.charAt(i) == target.charAt(i) && dp[i+1] != Long.MAX_VALUE){
                dp[i] = dp[i+ 1];
            }

            for(int j=0;j<m;j++){
                int l = length[j];
                if( i + l > n) continue;

                if(dp[i + l] == Long.MAX_VALUE) continue;

                if(check(source, target, i, rules.get(j))){
                    dp[i] = Math.min(dp[i], modifiedCost[j] + dp[i + l]);
                }
            }
        }

        return dp[0] == Long.MAX_VALUE ? -1 : (int)dp[0];
    }


    private boolean check(String src, String target, int start, List<String> rule){
        String pattern = rule.get(0);
        String replace = rule.get(1);

        for(int j=0;j<pattern.length();j++){
            char p = pattern.charAt(j);
            char s = src.charAt(start + j);
            char t = target.charAt(start + j);
            char r = replace.charAt(j);

            if(p!='*' && p!=s) return false;
            if(t != r) return false;
        }

        return true;
    }
}