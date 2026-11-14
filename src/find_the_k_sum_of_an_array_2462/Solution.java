package find_the_k_sum_of_an_array_2462;

import java.util.*;
class Solution {
    public long kSum(int[] nums, int k) {
        long sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += Math.max(nums[i], 0);
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        PriorityQueue<long[]> que= new PriorityQueue<>((a,b) -> Long.compare(b[0], a[0]));
        que.offer(new long[]{sum, 0});
        for(int i=0;i<k;i++){
            long next[] = que.poll();
            sum = next[0];
            int ind = (int)next[1];

            if(ind < n){
                que.offer(new long[]{sum - nums[ind], ind + 1});
            }

            if( ind > 0 && ind < n){
                que.offer(new long[]{sum + nums[ind-1] - nums[ind], ind + 1});
            }
        }

        return sum;

    }
}