package find_two_non_overlapping_sub_arrays_each_with_target_sum_1573;

import java.util.*;
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        map.put(0, -1);
        for(int i=0;i<n;i++){
            sum += arr[i];
            map.put(sum, i);
        }

        sum = 0;
        int left = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(map.containsKey(sum - target)){
                left = Math.min(left, i - map.get(sum - target));


            }

            if(map.containsKey(sum + target) && left < Integer.MAX_VALUE){
                ans = Math.min(ans, left + map.get(sum+target)-i);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}