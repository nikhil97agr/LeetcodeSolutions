package minimum_cost_of_buying_candies_with_discount_2248;

import java.util.*;
class Solution {
    public int minimumCost(int[] cost) {
       int n = cost.length;
       int ans = 0;
       Arrays.sort(cost);
       for(int i=n-1;i>=0;i-=3){
        ans += cost[i];
        if(i-1 >=0) ans += cost[i-1];
       } 

       return ans;
    }
}