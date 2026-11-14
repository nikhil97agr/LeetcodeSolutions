package inverse_coin_change_3903;

import java.util.*;
class Solution {
    public List<Integer> findCoins(int[] numWays) {
        List<Integer> list = new ArrayList<>();
        int n =numWays.length;
        for(int i=1;i<=n;i++){
            Integer dp[][] = new Integer[i+1][list.size()];
            int val = numWays[i-1];
             int cnt = solve(i, list, 0, list.size(), dp);
            if(cnt == val){
                continue;
            }

            if(cnt + 1 == val){
                list.add(i);
                 continue;
            }
            return new ArrayList<>();
        }

        return list;
    }

    private int solve(int val, List<Integer> list, int ind, int n, Integer dp[][]){
        if(val ==0) return 1;
        if(val < 0) return 0;

        if(ind == n) return 0;

        if(dp[val][ind]!=null) return dp[val][ind];

        int ans = 0;

        int cnt = 0;
        while(val - cnt*list.get(ind) >= 0){
            ans += solve(val - cnt * list.get(ind), list, ind+1, n, dp);
            cnt++;
        }

        return dp[val][ind] = ans;
    }
}