package maximum_product_after_k_increments_2329;

import java.util.*;
class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int x : nums){
            que.offer(x);
        }

        while( k-- > 0){
            int x = que.poll();

            x++;
            que.offer(x);
        }
        
        int ans = 1;
        while(!que.isEmpty()){
            ans = prod(ans, que.poll());
        }
        return ans;
    }

    private int prod(long a, long b){
        long prod = a*b;
        long mod = (long)1e9 + 7;
        return (int)(prod%mod);
    }
}