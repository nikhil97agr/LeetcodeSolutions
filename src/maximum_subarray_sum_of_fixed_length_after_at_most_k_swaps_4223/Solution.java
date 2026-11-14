package maximum_subarray_sum_of_fixed_length_after_at_most_k_swaps_4223;

import java.util.*;
class Solution {
    public long maxSum(int[] nums, int length, int k) {
        long ans = Long.MIN_VALUE;

        int n = nums.length;
        for(int i=0;i<= n - length;i++){
            var q1 = new PriorityQueue<Long>();
            for(int j=i;j < i + length;j++){
                q1.offer(1l * nums[j]);
            }   
            var q2 = new PriorityQueue<Long>(Collections.reverseOrder());
            int cnt = k;
            for(int j=0;j<n ;j++){
                if( j >=i && j < i + length) continue;
                q2.offer(1l * nums[j]);
            }

            while(cnt > 0 && !q2.isEmpty() && q2.peek() > q1.peek()){
                long v = q2.poll();
                q1.poll();
                q1.offer(v);
                cnt--;
            }

            ans = Math.max(ans, q1.stream().reduce(0l, Long::sum));
        }
        return ans;
    }
}