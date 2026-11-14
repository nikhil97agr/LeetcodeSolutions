package maximize_the_profit_as_the_salesman_2979;

import java.util.*;
class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (l1, l2)->{
            int s1 = l1.get(0);
            int e1 = l1.get(1);
            int s2 = l2.get(0);
            int e2 = l2.get(1);

            if(s1 == s2){
                return e1 -e2;
            }
            return  s1 - s2;
        });
        Integer dp[] = new Integer[offers.size()];
        return solve(offers.size(), offers, 0, dp);
    }

    private int solve(int n, List<List<Integer>> list, int i, Integer []dp){
        if(i>=n) return 0;
        if(dp[i] !=null) return dp[i];
        int ans1 = solve(n, list, i+1, dp);
        int ind = binarySearch(list, i+1, n-1, list.get(i).get(1));

        int ans2 = solve(n, list, ind, dp) + list.get(i).get(2);

        return dp[i] = Math.max(ans1, ans2);
    }

    private int binarySearch(List<List<Integer>> list, int start, int end, int val){
        int ind = end+1;

        while(start <= end){
            int mid = (start + end) /2;

            int s = list.get(mid).get(0);

            if(val >= s){
                start = mid+1;
            }else{
                end = mid-1;
                ind = mid;
            }
        }

        return ind;
    }


}