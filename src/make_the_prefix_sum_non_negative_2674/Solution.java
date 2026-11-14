package make_the_prefix_sum_non_negative_2674;

import java.util.*;
class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        int n = nums.length;
        long prefix[] = new long[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        PriorityQueue<Long> que =new PriorityQueue<>();
        int ans = 0;
        long sum = 0;
        for(int i=0;i<n;i++){
            if(nums[i] < 0){
                que.offer(1l*nums[i]);
            }

            while(prefix[i] - sum  < 0){
                sum += que.poll();
                ans++;
            }
        }
        return ans;
    }
}