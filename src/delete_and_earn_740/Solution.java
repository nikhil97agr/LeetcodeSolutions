package delete_and_earn_740;

import java.util.*;
class Solution {
    public int deleteAndEarn(int[] nums) {
       TreeMap<Integer, Integer> map = new TreeMap<>();
       int n = nums.length;
       for(int x : nums){
           map.putIfAbsent(x, 0);
           map.put(x, map.get(x)+1);
       }
      List<Integer> list = new ArrayList<>(map.keySet());
      n = list.size();
       int dp[] = new int[n];
       Arrays.fill(dp, -1);

       return solve(0, n, list, dp, map);
    }

    private int solve(int ind, int n, List<Integer> list, int []dp, TreeMap<Integer, Integer> map){
        if(ind==n){
            return 0;
        }

        if(ind==n-1){
            return map.get(list.get(ind))*list.get(ind);
        }

        if(dp[ind]!=-1){
            return dp[ind];
        }

        if(list.get(ind)+1==list.get(ind+1)){
            int x = list.get(ind);
            int cnt = map.get(x);
            dp[ind] = Math.max(x*cnt+solve(ind+2, n, list, dp, map), solve(ind+1, n, list, dp, map));
        }else{
            int x = list.get(ind);
            int cnt = map.get(x);
            dp[ind] = x*cnt+ solve(ind+1, n, list, dp, map);
        }
        return dp[ind];
    }
}