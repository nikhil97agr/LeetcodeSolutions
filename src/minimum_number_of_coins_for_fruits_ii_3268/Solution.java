package minimum_number_of_coins_for_fruits_ii_3268;

import java.util.*;
class Solution {
    public int minimumCoins(int[] prices) {
       Deque<Integer> que  =new ArrayDeque<>();
       int n = prices.length;
       int dp[] = new int[n];
       dp[0] = prices[0];
       que.offer(0);
       for(int i=1;i<n;i++){
        dp[i] = dp[que.getFirst() ] + prices[i];

        while(!que.isEmpty() && que.getFirst() * 2 + 1 < i){
            que.removeFirst();
        }
        while(!que.isEmpty() && dp[que.getLast()] >= dp[i]){
            que.removeLast();
        }

        que.addLast(i);
       }


       return dp[que.getFirst()];

    }
}