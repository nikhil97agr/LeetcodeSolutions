package range_sum_of_sorted_subarray_sums_1615;

import java.util.*;
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> list = new ArrayList<>();
        long mod = (long)1e9+7;
        for(int i=0;i<n;i++){
            long sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        long ans = 0;
        for(int i=left-1;i<right;i++){
            ans += list.get(i);
            ans%=mod;
        }
        return (int)ans;
    }
}