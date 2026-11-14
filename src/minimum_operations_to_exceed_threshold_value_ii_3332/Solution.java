package minimum_operations_to_exceed_threshold_value_ii_3332;

import java.util.*;
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> que = new PriorityQueue<>();
        for(int x : nums){
            que.offer(1l*x);
        }

        int ans = 0;

        while(que.size() > 1 && que.peek() < k){
            long first = que.poll();
            long second = que.poll();
            long next = Math.min(first, second)*2 + Math.max(first, second);
            que.offer(next);
            ans++;
        }
        return ans;
    }
}