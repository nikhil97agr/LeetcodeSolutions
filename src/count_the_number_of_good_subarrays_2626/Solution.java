package count_the_number_of_good_subarrays_2626;

import java.util.*;
class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map =new HashMap<Integer, Integer>();
        int i=0;
        int j=0;
        long count = 0;
        int n = nums.length;
        long result = 0;
        while(j<n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            count += map.get(nums[j])-1;
            while(i<j && count >=k){
                result += n-j;
                map.put(nums[i], map.get(nums[i])-1);
                count -= map.get(nums[i]);
                i++;
            }
            j++;
        }
        return result;
    }
}