package maximum_sum_of_almost_unique_subarray_2954;

import java.util.*;
class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0;
        long sum = 0;
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0,j=0;i<n;i++){
            add(map, nums.get(i));
            sum += nums.get(i);

            if(i-j +1 ==k){
                if(map.size() >= m){
                    ans = Math.max(ans, sum);
                }
                sum -= nums.get(j);
                remove(map, nums.get(j));
                j++;
            }
        }

        return ans;
    }

    private void add(Map<Integer, Integer> map, int val){
        map.merge(val, 1, Integer::sum);
    }

    private void remove(Map<Integer, Integer> map, int val){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);
    }
}