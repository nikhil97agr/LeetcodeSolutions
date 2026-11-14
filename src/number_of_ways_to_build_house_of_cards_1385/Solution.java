package number_of_ways_to_build_house_of_cards_1385;

import java.util.*;
class Solution {
    public int houseOfCards(int n) {
        List<Integer> nums = new ArrayList<>();
        for(int i=2;i<=n;i+=3){
            nums.add(i);
        }
        Integer dp[][] = new Integer[n+1][nums.size()];
        return solve(nums, 0, n, dp);
    }

    private int solve(List<Integer> list, int ind, int n, Integer dp[][]){
        if(n==0) return 1;
        if(n <0) return 0;
        if(ind== list.size()) return 0;
        if(dp[n][ind]!=null) return dp[n][ind];
        return dp[n][ind] = solve(list, ind+1, n-list.get(ind), dp) + solve(list, ind+1, n, dp);
    }
}