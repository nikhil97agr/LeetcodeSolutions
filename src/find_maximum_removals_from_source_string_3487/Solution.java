package find_maximum_removals_from_source_string_3487;

import java.util.*;
class Solution {
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        Set<Integer> set = new HashSet<>();
        for(int x : targetIndices){
            set.add(x);
        }
        Integer dp[][] =new Integer[source.length()+1][pattern.length()+1];
        return solve(0, 0, source.toCharArray(), pattern.toCharArray(), set, source.length(), pattern.length(), dp);
    }

    private int solve(int i, int j, char src[], char[] pattern, Set<Integer> set, int n, int m, Integer dp[][]){

        if( i==n){
            if(j == m) return 0;
            return Integer.MIN_VALUE;
        }

        if(j == m){
            int cnt = 0;
            for(int k=i;k<n;k++){
                if(set.contains(k))cnt++;
            }

            return cnt;
        }

        if(dp[i][j] !=null) return dp[i][j];

        int ans = Integer.MIN_VALUE;
        if(set.contains(i)){
            int a = solve(i+1, j, src, pattern, set, n, m, dp);
            if(a != Integer.MIN_VALUE){
                ans =Math.max(ans, 1  + a);
            }
            
        }
        if(src[i] == pattern[j]){
                int b = solve(i+1, j+1, src, pattern, set, n, m, dp);
                if(b!=Integer.MIN_VALUE){
                    ans = Math.max(ans,  b);
                }
        }else{
            int a= solve(i+1, j, src, pattern, set, n, m, dp);
            ans = Math.max(ans, a);
        }

        return dp[i][j] = ans;
    }


}