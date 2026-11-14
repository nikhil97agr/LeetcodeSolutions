package sum_of_distances_2721;

import java.util.*;
class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> index = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();
        int n = nums.length;
        long ans[] = new long[n];

        for(int i=0;i<n;i++){
            int val = nums[i];
            int c = cnt.getOrDefault(val, 0);
            int ind = index.getOrDefault(val, 0);

            long total =sum.getOrDefault(val, 0l)+ 1l*c*(i-ind);

            ans[i] +=  total;
            cnt.merge(val, 1, Integer::sum);
            index.put(val, i);
            sum.put(val, total);

        }

        cnt.clear();
        index.clear();
        sum.clear();

        for(int i=n-1;i>=0;i--){
            int val = nums[i];
            int c = cnt.getOrDefault(val, 0);
            int ind = index.getOrDefault(val, 0);
            long total =sum.getOrDefault(val, 0l)+ 1l*c*(ind - i);

            ans[i] += total;
            cnt.merge(val, 1, Integer::sum);
            index.put(val, i);
            sum.put(val, total);

        }

        return ans;
    }
}