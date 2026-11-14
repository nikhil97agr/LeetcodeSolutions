package maximum_number_of_ways_to_partition_an_array_2135;

import java.util.*;
class Solution {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        long pre[]= new long[n];
        long suff[] = new long[n];

        pre[0] = nums[0];
        suff[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        for(int i=n-2;i>=0;i--){
            suff[i] = suff[i+1] + nums[i];
        }

        Map<Long, Integer> left = new HashMap<>();
        Map<Long, Integer> right = new HashMap<>();
        int ans= 0;
        for(int i=1;i<n;i++){
            long diff = pre[i-1] - suff[i];
            right.merge(diff, 1, Integer::sum);
            if(diff == 0l){
                ans++;
            }
        }

        for(int i=0;i<n;i++){
            long diff = k - nums[i];
            if(i > 0){
                long prev = pre[i-1] - suff[i];
                right.merge(prev, -1, Integer::sum);
                if(right.get(prev) ==0 ){
                    right.remove(prev);
                }
                left.merge(prev, 1, Integer::sum);
            }

            ans = Math.max(ans, left.getOrDefault(diff, 0) + right.getOrDefault(-diff, 0));
        }

        return ans;
    }
}